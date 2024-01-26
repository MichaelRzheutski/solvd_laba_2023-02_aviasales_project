package com.solvd.aviasales.domain.actions;

import com.solvd.aviasales.domain.session.ResultCollector;
import com.solvd.aviasales.domain.session.RouteCollector;

import java.util.concurrent.atomic.AtomicInteger;

import static com.solvd.aviasales.util.Printers.*;

public class CollectorActions {

    public static void showRouteCollection(RouteCollector collector) {
        PRINTLN.info("MINIMUM PRICE ROUTE COLLECTION:");
        PRINTLN.info(String.format("\tRoute: %s-%s, %s class, transfers: no more than %d",
                collector.getCountryFrom(), collector.getCountryTo(), collector.getSeatClass(), collector.getTransfersNumber()));
        if (collector.getMinPriceRouteCollection().size() > 0) {
            collector.getMinPriceRouteCollection().forEach(route -> PRINTLN.info(String.format("\t- %s", route)));
            PRINTLN.info(String.format("\tTotal price: $%s", collector.getMinPriceRouteTotalPrice()));
            PRINTLN.info(String.format("\tTotal distance: %skm", collector.getMinPriceRouteTotalDistance()));
        } else {
            PRINTLN.info("\t(no routes)");
        }
        PRINTLN.info("MINIMUM DISTANCE ROUTE COLLECTION:");
        PRINTLN.info(String.format("\tRoute: %s-%s, %s class, transfers: no more than %d",
                collector.getCountryFrom(), collector.getCountryTo(), collector.getSeatClass(), collector.getTransfersNumber()));
        if (collector.getMinDistanceRouteCollection().size() > 0) {
            collector.getMinDistanceRouteCollection().forEach(route -> PRINTLN.info(String.format("\t- %s", route)));
            PRINTLN.info(String.format("\tTotal price: $%s", collector.getMinDistanceRouteTotalPrice()));
            PRINTLN.info(String.format("\tTotal distance: %skm", collector.getMinDistanceRouteTotalDistance()));
        } else {
            PRINTLN.info("\t(no routes)");
        }
    }

    public static void showResultCollection(ResultCollector result) {
        PRINT2LN.info("RESULT ROUTE COLLECTIONS:");
        AtomicInteger index = new AtomicInteger(1);
        result.getResult().forEach(collector -> {
            PRINTLN.info("-----");
            PRINTLN.info(String.format("%s RESULT COLLECTION:", index));
            showRouteCollection(collector);
            index.getAndIncrement();
        });
    }
}
