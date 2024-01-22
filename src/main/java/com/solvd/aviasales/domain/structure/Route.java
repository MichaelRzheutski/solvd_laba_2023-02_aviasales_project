package com.solvd.aviasales.domain.structure;

public class Route {
    private Long id;
    private String country_from;
    private String country_to;
    private String seatClass;
    private Double distance;
    private Double price;
    private Airline airline;

    public Route() { }

    public Route(String country_from,
                 String country_to,
                 String seatClass,
                 Double distance,
                 Double price,
                 Airline airline) {
        this.country_from = country_from;
        this.country_to = country_to;
        this.seatClass = seatClass;
        this.distance = distance;
        this.price = price;
        this.airline = airline;
    }

    public Route(Long id,
                 String country_from,
                 String country_to,
                 String seatClass,
                 Double distance,
                 Double price,
                 Airline airline) {
        this.id = id;
        this.country_from = country_from;
        this.country_to = country_to;
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

    public String getCountry_from() {
        return country_from;
    }

    public void setCountry_from(String country_from) {
        this.country_from = country_from;
    }

    public String getCountry_to() {
        return country_to;
    }

    public void setCountry_to(String country_to) {
        this.country_to = country_to;
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
                id, country_from, country_to, airline, seatClass, distance, price);
    }
}
