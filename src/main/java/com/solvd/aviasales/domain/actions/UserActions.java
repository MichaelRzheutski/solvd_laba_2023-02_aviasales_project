package com.solvd.aviasales.domain.actions;

import com.solvd.aviasales.domain.actions.entity_actions.RouteActions;
import com.solvd.aviasales.domain.session.floyd_warshall.CheapestRouteCalculator;
import com.solvd.aviasales.domain.session.floyd_warshall.RouteCalculatorHelper;
import com.solvd.aviasales.domain.session.RouteCollector;
import com.solvd.aviasales.domain.session.floyd_warshall.ShortestRouteCalculator;
import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.service.RouteService;
import com.solvd.aviasales.util.console_menu.RequestMethods;
import com.solvd.aviasales.util.functional_interfaces.IPrintAsMenu;

import java.util.List;

import static com.solvd.aviasales.util.Printers.*;

public class UserActions {
    private final static IPrintAsMenu<Integer, String> PRINT_AS_MENU = (index, line) -> PRINTLN.info(String.format("[%d]: %s", index, line));

    public static RouteCollector getRouteCollectionFromConsole() {
        PRINT2LN.info("ROUTE SEARCH");
        RouteCollector collector = new RouteCollector();
        RouteService routeService = new RouteService();
        String seatClass = RouteActions.getSeatClassFromConsole();
        List<Route> routes = routeService.getBySeatClass(seatClass);
        String countryFrom = getCountryFromConsole(routes, "departure");
        String countryTo = getCountryFromConsole(routes, "arrival");
        int transfersNumber = getTransfersNumberFromConsole();
        PRINTLN.info("");
        List<Route> minimumPriceCollection = null;
        List<Route> minimumDistanceCollection = null;
        switch (transfersNumber) {
            case (1) -> {
                minimumPriceCollection = CheapestRouteCalculator.getMinimumPriceWithOneTransfer(routes, countryFrom, countryTo);
                minimumDistanceCollection = ShortestRouteCalculator.getMinimumDistanceWithOneTransfer(routes, countryFrom, countryTo);
            }
            case (2) -> {
                minimumPriceCollection = CheapestRouteCalculator.getMinimumPriceWithTwoTransfers(routes, countryFrom, countryTo);
                minimumDistanceCollection = ShortestRouteCalculator.getMinimumDistanceWithTwoTransfers(routes, countryFrom, countryTo);
            }
            case (3) -> {
                minimumPriceCollection = CheapestRouteCalculator.getMinimumPriceWithThreeTransfers(routes, countryFrom, countryTo);
                minimumDistanceCollection = ShortestRouteCalculator.getMinimumDistanceWithThreeTransfers(routes, countryFrom, countryTo);
            }
        }
        collector.setCountryFrom(countryFrom);
        collector.setCountryTo(countryTo);
        collector.setSeatClass(seatClass);
        collector.setTransfersNumber(transfersNumber);
        if (minimumPriceCollection != null) {
            collector.setMinPriceRouteCollection(minimumPriceCollection);
            double minPriceTotalPrice = collector.getMinPriceRouteCollection()
                    .stream()
                    .mapToDouble(Route::getPrice)
                    .sum();
            collector.setMinPriceRouteTotalPrice(minPriceTotalPrice);
            double minPriceTotalDistance = collector.getMinPriceRouteCollection()
                    .stream()
                    .mapToDouble(Route::getDistance)
                    .sum();
            collector.setMinPriceRouteTotalDistance(minPriceTotalDistance);
        }
        if (minimumDistanceCollection != null) {
            collector.setMinDistanceRouteCollection(minimumDistanceCollection);
            double minDistanceTotalDistance = collector.getMinDistanceRouteCollection()
                    .stream()
                    .mapToDouble(Route::getDistance)
                    .sum();
            collector.setMinDistanceRouteTotalDistance(minDistanceTotalDistance);
            double minDistanceTotalPrice = collector.getMinDistanceRouteCollection()
                    .stream()
                    .mapToDouble(Route::getPrice)
                    .sum();
            collector.setMinDistanceRouteTotalPrice(minDistanceTotalPrice);
        }
        return collector;
    }

    private static String getCountryFromConsole(List<Route> routes, String point) {
        List<String> countries = RouteCalculatorHelper.getListOfCountries(routes);
        PRINTLN.info(String.format("Choose %s country:", point));
        int index = 1;
        for (String country : countries) {
            PRINT_AS_MENU.print(index, country);
            index++;
        }
        return countries.get(RequestMethods.getNumberFromChoice("country", index - 1) - 1);
    }

    private static int getTransfersNumberFromConsole() {
        PRINTLN.info("Choose maximum number of transfers:");
        int index = 1;
        for (Transfer transfer : Transfer.values()) {
            PRINT_AS_MENU.print(index, transfer.getTitle());
            index++;
        }
        return RequestMethods.getNumberFromChoice("number of transfers", index - 1);
    }
}
