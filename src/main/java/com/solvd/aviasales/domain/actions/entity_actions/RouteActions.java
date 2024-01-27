package com.solvd.aviasales.domain.actions.entity_actions;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.service.RouteService;
import com.solvd.aviasales.util.console_menu.RequestMethods;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.solvd.aviasales.util.Printers.*;

public class RouteActions implements IEntityActions {

    @Override
    public void showEntityEntries() {
        List<Route> routes = new RouteService().getAll();
        PRINT2LN.info("ALL ROUTES:");
        if (routes.size() > 0) {
            routes.forEach(route -> PRINTLN.info(String.format("- %s", route)));
        } else {
            PRINTLN.info("(no routes)");
        }
    }

    @Override
    public void registerEntityEntry() {
        PRINT2LN.info("REGISTERING ROUTE");
        RouteService routeService = new RouteService();
        String countryFrom = RequestMethods.getStringValueFromConsole("the departure country");
        String countryTo = RequestMethods.getStringValueFromConsole("the arrival country");
        String seatClass = getSeatClassFromConsole();
        Double distance = RequestMethods.getDoubleValueFromConsole("the distance");
        Double price = RequestMethods.getDoubleValueFromConsole("the price");
        Airline airline = AirlineActions.getExistingAirlineFromConsole();
        Route route = new Route(countryFrom, countryTo, seatClass, distance, price, airline);
        routeService.save(route);
        PRINT2LN.info(String.format("ROUTE %s-%s WAS REGISTERED", countryFrom, countryTo));
    }

    @Override
    public void removeEntityEntry() {
        PRINT2LN.info("REMOVING ROUTE");
        RouteService routeService = new RouteService();
        Airline airline = AirlineActions.getExistingAirlineFromConsole();
        Route route = getExistingRouteByAirlineFromConsole(airline);
        routeService.delete(route.getId());
        PRINT2LN.info(String.format("ROUTE %s-%s WAS REMOVED", route.getCountryFrom(), route.getCountryTo()));
    }

    @Override
    public void updateEntityEntry() {
        PRINT2LN.info("UPDATING ROUTE");
        RouteService routeService = new RouteService();
        Airline airline = AirlineActions.getExistingAirlineFromConsole();
        Route route = getExistingRouteByAirlineFromConsole(airline);
        Field field = getRouteClassFieldFromConsole();
        switch (field.getName()) {
            case ("countryFrom") -> route.setCountryFrom(RequestMethods.getStringValueFromConsole("new value"));
            case ("countryTo") -> route.setCountryTo(RequestMethods.getStringValueFromConsole("new value"));
            case ("seatClass") -> route.setSeatClass(getSeatClassFromConsole());
            case ("distance") -> route.setDistance(RequestMethods.getDoubleValueFromConsole("new value"));
            case ("price") -> route.setPrice(RequestMethods.getDoubleValueFromConsole("new value"));
            case ("airline") -> route.setAirline(AirlineActions.getExistingAirlineFromConsole());
        }
        routeService.update(route);
        PRINT2LN.info(String.format("ROUTE N%s WAS UPDATED", route.getId()));
    }

    protected static Route getExistingRouteByAirlineFromConsole(Airline airline) {
        PRINTLN.info("Choose the route:");
        int index = 1;
        for (Route route : airline.getRoutes()) {
            PRINT_AS_MENU.print(index, route.toString());
            index++;
        }
        return airline.getRoutes().get(RequestMethods.getNumberFromChoice("the route number", index - 1) - 1);
    }

    public static String getSeatClassFromConsole() {
        RouteService routeService = new RouteService();
        List<String> classes = routeService.getAll()
                .stream()
                .map(Route::getSeatClass)
                .collect(Collectors.toSet())
                .stream()
                .toList();
        PRINTLN.info("Choose the seat class:");
        int index = 1;
        for (String seatClass : classes) {
            PRINT_AS_MENU.print(index, seatClass);
            index++;
        }
        return classes.get(RequestMethods.getNumberFromChoice("the seat class number", index - 1) - 1);
    }

    private static Field getRouteClassFieldFromConsole() {
        int index = 1;
        PRINTLN.info("Choose the field for update:");
        List<Field> allRouteFields = List.of(Route.class.getDeclaredFields());
        List<Field> routeFields = new ArrayList<>();
        for (Field routeField : allRouteFields) {
            if (!routeField.getName().equals("id")) {
                PRINT_AS_MENU.print(index, routeField.getName());
                routeFields.add(routeField);
                index++;
            }
        }
        return routeFields.get(RequestMethods.getNumberFromChoice("the field number", index - 1) - 1);
    }
}
