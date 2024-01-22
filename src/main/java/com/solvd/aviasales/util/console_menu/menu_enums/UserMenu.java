package com.solvd.aviasales.util.console_menu.menu_enums;

public enum UserMenu implements IMenu {
    CHOOSE_DIRECTION("Choose direction"),
    MAIN_MENU("<-- MAIN MENU"),
    EXIT("EXIT AND SAVE");

    private final String title;

    UserMenu(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
