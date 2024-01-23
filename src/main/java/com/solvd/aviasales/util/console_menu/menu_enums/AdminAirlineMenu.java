package com.solvd.aviasales.util.console_menu.menu_enums;

public enum AdminAirlineMenu implements IMenu {
    SHOW_AIRLINES("Show all airlines"),
    CREATE_AIRLINE("Create airline"),
    UPDATE_AIRLINE("Update airline"),
    DELETE_AIRLINE("Delete airline"),
    ADMIN_MENU("<-- ADMIN MENU"),
    EXIT("EXIT AND SAVE");

    private final String title;

    AdminAirlineMenu(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
