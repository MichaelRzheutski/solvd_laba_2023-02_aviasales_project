package com.solvd.aviasales.domain.structure;

public class Route {
    private Long id;
    private String country_from;
    private String country_to;
    private String seat_class;
    private Double distance;
    private Double price;
    private Airline airline;

    public Route() {
    }

    public Route(String country_from,
                 String country_to,
                 String seat_class,
                 Double distance,
                 Double price,
                 Airline airline) {
        this.country_from = country_from;
        this.country_to = country_to;
        this.seat_class = seat_class;
        this.distance = distance;
        this.price = price;
        this.airline = airline;
    }

    public Route(Long id,
                 String country_from,
                 String country_to,
                 String seat_class,
                 Double distance,
                 Double price,
                 Airline airline) {
        this.id = id;
        this.country_from = country_from;
        this.country_to = country_to;
        this.seat_class = seat_class;
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

    public String getSeat_class() {
        return seat_class;
    }

    public void setSeat_class(String seat_class) {
        this.seat_class = seat_class;
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
                id, country_from, country_to, airline, seat_class, distance, price);
    }
}
