package com.solvd.aviasales.domain.structure;

public class Route {
    private Long id;
    private String countryFrom;
    private String countryTo;
    private String seatClass;
    private Double distance;
    private Double price;
    private Airline airline;

    public Route() { }

    public Route(String countryFrom,
                 String countryTo,
                 String seatClass,
                 Double distance,
                 Double price,
                 Airline airline) {
        this.countryFrom = countryFrom;
        this.countryTo = countryTo;
        this.seatClass = seatClass;
        this.distance = distance;
        this.price = price;
        this.airline = airline;
    }

    public Route(Long id,
                 String countryFrom,
                 String countryTo,
                 String seatClass,
                 Double distance,
                 Double price,
                 Airline airline) {
        this.id = id;
        this.countryFrom = countryFrom;
        this.countryTo = countryTo;
        this.seatClass = seatClass;
        this.distance = distance;
        this.price = price;
        this.airline = airline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return String.format("Route:[%s, %s-%s], %s, Class:[%s], Distance:[%s], Price:[%s]",
                id, countryFrom, countryTo, airline, seatClass, distance, price);

    }
}
