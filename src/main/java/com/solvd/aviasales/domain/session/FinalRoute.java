package com.solvd.aviasales.domain.session;

import com.solvd.aviasales.domain.structure.Route;

import java.util.List;

public class FinalRoute {
    private String routeName;
    private String seatClass;
    private double totalPrice;
    private double totalDistance;
    private int transfers;
    List<Route> routeCollection;

    public FinalRoute() { }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
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

    public int getTransfers() {
        return transfers;
    }

    public void setTransfers(int transfers) {
        this.transfers = transfers;
    }

    public List<Route> getRouteCollection() {
        return routeCollection;
    }

    public void setRouteCollection(List<Route> routeCollection) {
        this.routeCollection = routeCollection;
    }
}
