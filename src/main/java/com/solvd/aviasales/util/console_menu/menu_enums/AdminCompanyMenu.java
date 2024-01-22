package com.solvd.aviasales.util.console_menu.menu_enums;

public enum AdminCompanyMenu implements IMenu {
    SHOW_COMPANIES("Show all companies"),
    CREATE_COMPANY("Create company"),
    UPDATE_COMPANY("Update company"),
    DELETE_COMPANY("Delete company"),
    ADMIN_MENU("<-- ADMIN MENU"),
    EXIT("EXIT AND SAVE");

    private final String title;

    AdminCompanyMenu(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
