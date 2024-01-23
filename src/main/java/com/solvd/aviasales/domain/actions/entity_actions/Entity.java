package com.solvd.aviasales.domain.actions.entity_actions;

public enum Entity {
    COMPANY("COMPANY", 1, "COMPANY ACTIONS"),
    AIRLINE("AIRLINE", 2, "AIRLINE ACTIONS"),
    ROUTE("ROUTE", 3, "ROUTE ACTIONS");

    private final String title;
    private final int number;
    private final String description;

    Entity(String title, int number, String description) {
        this.title = title;
        this.number = number;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}