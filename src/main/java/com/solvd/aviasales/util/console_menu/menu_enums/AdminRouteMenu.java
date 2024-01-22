package com.solvd.aviasales.util.console_menu.menu_enums;

public enum AdminRouteMenu implements IMenu {
    SHOW_ROUTES("Show all routes"),
    CREATE_ROUTE("Create route"),
    UPDATE_ROUTE("Update route"),
    DELETE_ROUTE("Delete route"),
    ADMIN_MENU("<-- ADMIN MENU"),
    EXIT("EXIT AND SAVE");

    private final String title;

    AdminRouteMenu(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
