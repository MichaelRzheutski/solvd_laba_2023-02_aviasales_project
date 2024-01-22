package com.solvd.aviasales.domain.session;

import com.solvd.aviasales.domain.structure.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteCollector {
    private List<Route> minimumPriceRouteCollection;
    private List<Route> minimumDistanceRouteCollection;

    public RouteCollector() {
        minimumPriceRouteCollection = new ArrayList<>();
        minimumDistanceRouteCollection = new ArrayList<>();
    }

    public List<Route> getMinimumPriceRouteCollection() {
        return minimumPriceRouteCollection;
    }

    public void setMinimumPriceRouteCollection(List<Route> minimumPriceRouteCollection) {
        this.minimumPriceRouteCollection = minimumPriceRouteCollection;
    }

    public List<Route> getMinimumDistanceRouteCollection() {
        return minimumDistanceRouteCollection;
    }

    public void setMinimumDistanceRouteCollection(List<Route> minimumDistanceRouteCollection) {
        this.minimumDistanceRouteCollection = minimumDistanceRouteCollection;
    }

    public void addRouteToMinimumPriceRouteCollection(Route route) {
        minimumPriceRouteCollection.add(route);
    }

    public void addRouteToMinimumDistanceRouteCollection(Route route) {
        minimumDistanceRouteCollection.add(route);
    }
}
