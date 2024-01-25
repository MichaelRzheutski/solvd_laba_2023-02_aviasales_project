package com.solvd.aviasales.domain.session;

import com.solvd.aviasales.domain.structure.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteCollector {
    private String countryFrom;
    private String countryTo;
    private String seatClass;
    private int transfersNumber;
    private double totalPrice;
    private double totalDistance;
    private List<Route> minimumPriceRouteCollection;
    private List<Route> minimumDistanceRouteCollection;

    public RouteCollector() {
        minimumPriceRouteCollection = new ArrayList<>();
        minimumDistanceRouteCollection = new ArrayList<>();
    }

    public String getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(String countryFrom) {
        this.countryFrom = countryFrom;
    }

    public String getCountryTo() {
        return countryTo;
    }

    public void setCountryTo(String countryTo) {
        this.countryTo = countryTo;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public int getTransfersNumber() {
        return transfersNumber;
    }

    public void setTransfersNumber(int transfersNumber) {
        this.transfersNumber = transfersNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
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
}
