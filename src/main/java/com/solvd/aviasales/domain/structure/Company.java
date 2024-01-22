package com.solvd.aviasales.domain.structure;

import java.util.List;

public class Company {
    private Long id;
    private String title;
    private List<Airline> airlines;

    public Company() { }

    public Company(String title) {
        this.title = title;
    }

    public Company(Long id,
                   String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    @Override
    public String toString() {
        return String.format("Company:[%s]", title);
    }
}
