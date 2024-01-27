package com.solvd.aviasales.domain.session;

import com.solvd.aviasales.domain.structure.Route;
import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

//@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@XmlType(propOrder={"countryFrom", "countryTo", "seatClass", "transfersNumber",
                    "minPriceRouteTotalPrice", "minDistanceRouteTotalPrice",
                    "minPriceRouteTotalDistance", "minDistanceRouteTotalDistance",
                    "minPriceRouteCollection", "minDistanceRouteCollection"})
public class RouteCollector {
    private String countryFrom;
    private String countryTo;
    private String seatClass;
    private int transfersNumber;
    private double minPriceRouteTotalPrice;
    private double minDistanceRouteTotalPrice;
    private double minPriceRouteTotalDistance;
    private double minDistanceRouteTotalDistance;
    private List<Route> minPriceRouteCollection;
    private List<Route> minDistanceRouteCollection;

    public RouteCollector() {
        minPriceRouteCollection = new ArrayList<>();
        minDistanceRouteCollection = new ArrayList<>();
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

    public double getMinPriceRouteTotalPrice() {
        return minPriceRouteTotalPrice;
    }

    public void setMinPriceRouteTotalPrice(double minPriceRouteTotalPrice) {
        this.minPriceRouteTotalPrice = minPriceRouteTotalPrice;
    }

    public double getMinDistanceRouteTotalDistance() {
        return minDistanceRouteTotalDistance;
    }

    public void setMinDistanceRouteTotalDistance(double minDistanceRouteTotalDistance) {
        this.minDistanceRouteTotalDistance = minDistanceRouteTotalDistance;
    }

    public double getMinDistanceRouteTotalPrice() {
        return minDistanceRouteTotalPrice;
    }

    public void setMinDistanceRouteTotalPrice(double minDistanceRouteTotalPrice) {
        this.minDistanceRouteTotalPrice = minDistanceRouteTotalPrice;
    }

    public double getMinPriceRouteTotalDistance() {
        return minPriceRouteTotalDistance;
    }

    public void setMinPriceRouteTotalDistance(double minPriceRouteTotalDistance) {
        this.minPriceRouteTotalDistance = minPriceRouteTotalDistance;
    }

    public List<Route> getMinPriceRouteCollection() {
        return minPriceRouteCollection;
    }

    public void setMinPriceRouteCollection(List<Route> minPriceRouteCollection) {
        this.minPriceRouteCollection = minPriceRouteCollection;
    }

    public List<Route> getMinDistanceRouteCollection() {
        return minDistanceRouteCollection;
    }

    public void setMinDistanceRouteCollection(List<Route> minDistanceRouteCollection) {
        this.minDistanceRouteCollection = minDistanceRouteCollection;
    }
}
