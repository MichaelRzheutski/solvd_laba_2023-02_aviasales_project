package com.solvd.aviasales.util.console_menu.menu_enums;

public enum AdminMenu implements IMenu {
    ADMIN_COMPANY_MENU("ADMIN COMPANY MENU"),
    ADMIN_AIRLINE_MENU("ADMIN AIRLINE MENU"),
    ADMIN_ROUTE_MENU("ADMIN ROUTE MENU"),
    MAIN_MENU("<-- MAIN MENU"),
    EXIT("EXIT AND SAVE");

    private final String title;

    AdminMenu(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
