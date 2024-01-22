package com.solvd.aviasales.util.enums;

public enum Jackson {
    JACKSON("JACKSON");
    private final String jackson;

    Jackson(String jackson) {
        this.jackson = jackson;
    }

    public String getJackson() {
        return jackson;
    }

    @Override
    public String toString() {
        return jackson;
    }
}
