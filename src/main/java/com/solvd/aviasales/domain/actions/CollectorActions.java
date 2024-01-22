package com.solvd.aviasales.domain.actions;

import com.solvd.aviasales.domain.session.ResultCollector;
import com.solvd.aviasales.domain.session.RouteCollector;

import java.util.concurrent.atomic.AtomicInteger;

import static com.solvd.aviasales.util.Printers.*;

public class CollectorActions {

    public static void showRouteCollection(RouteCollector collector) {
        PRINTLN.info("MINIMUM PRICE ROUTE COLLECTION:");
        collector.getMinimumPriceRouteCollection().forEach(route -> PRINTLN.info("\t- " + route));
        PRINTLN.info("MINIMUM DISTANCE ROUTE COLLECTION:");
        collector.getMinimumDistanceRouteCollection().forEach(route -> PRINTLN.info("\t- " + route));
    }

    public static void showResultCollection(ResultCollector result) {
        PRINT2LN.info("RESULT ROUTE COLLECTIONS:");
        AtomicInteger index = new AtomicInteger(1);
        result.getResult().forEach(collector -> {
            PRINTLN.info(index + " RESULT COLLECTION:");
            showRouteCollection(collector);
            index.getAndIncrement();
        });
    }
}
