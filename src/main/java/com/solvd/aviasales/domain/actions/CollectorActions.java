package com.solvd.aviasales.domain.actions;

import com.solvd.aviasales.domain.session.ResultCollector;
import com.solvd.aviasales.domain.session.RouteCollector;

import java.util.concurrent.atomic.AtomicInteger;

import static com.solvd.aviasales.util.Printers.*;

public class CollectorActions {

    public static void showRouteCollection(RouteCollector collector) {
        PRINTLN.info("MINIMUM PRICE ROUTE COLLECTION:");
        PRINTLN.info(String.format("\tRoute: %s-%s, %s class, %d transfers",
                collector.getCountryFrom(), collector.getCountryTo(), collector.getSeatClass(), collector.getTransfersNumber()));
        if (collector.getMinimumPriceRouteCollection().size() > 0) {
            collector.getMinimumPriceRouteCollection().forEach(route -> PRINTLN.info("\t- " + route));
            PRINTLN.info(String.format("\tTotal price: $%S", collector.getTotalPrice()));
        } else {
            PRINTLN.info("\t(no routes)");
        }
        PRINTLN.info("MINIMUM DISTANCE ROUTE COLLECTION:");
        PRINTLN.info(String.format("\tRoute: %s-%s, %s class, %d transfers",
                collector.getCountryFrom(), collector.getCountryTo(), collector.getSeatClass(), collector.getTransfersNumber()));
        if (collector.getMinimumDistanceRouteCollection().size() > 0) {
            collector.getMinimumDistanceRouteCollection().forEach(route -> PRINTLN.info("\t- " + route));
            PRINTLN.info(String.format("\tTotal distance: %Skm", collector.getTotalDistance()));
        } else {
            PRINTLN.info("\t(no routes)");
        }
    }

    public static void showResultCollection(ResultCollector result) {
        PRINT2LN.info("RESULT ROUTE COLLECTIONS:");
        AtomicInteger index = new AtomicInteger(1);
        result.getResult().forEach(collector -> {
            PRINTLN.info("-----");
            PRINTLN.info(index + " RESULT COLLECTION:");
            showRouteCollection(collector);
            index.getAndIncrement();
        });
    }
}
