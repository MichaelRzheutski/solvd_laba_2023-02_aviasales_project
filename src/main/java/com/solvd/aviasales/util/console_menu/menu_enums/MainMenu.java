package com.solvd.aviasales.util.console_menu.menu_enums;

public enum MainMenu implements IMenu {
    USER_MENU("Run USER MENU"),
    ADMIN_MENU("Run ADMIN MENU"),
    EXIT("EXIT AND SAVE");

    private final String title;

    MainMenu(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
