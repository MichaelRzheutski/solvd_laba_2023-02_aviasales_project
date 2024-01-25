package com.solvd.aviasales.domain.actions;

public enum Transfer {
    ONE("One transfer", 1),
    TWO("Two transfers", 2),
    THREE("Three transfers", 3);

    private final String title;
    private final int transfersNumber;

    Transfer(String title, int transfersNumber) {
        this.title = title;
        this.transfersNumber = transfersNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getTransfersNumber() {
        return transfersNumber;
    }
}
