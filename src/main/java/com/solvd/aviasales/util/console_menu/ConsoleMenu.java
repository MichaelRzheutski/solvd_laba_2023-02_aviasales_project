package com.solvd.aviasales.util.console_menu;

import com.solvd.aviasales.domain.session.ResultCollector;
import com.solvd.aviasales.util.console_menu.menu_enums.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.solvd.aviasales.util.Printers.*;

public class ConsoleMenu {
    protected static final Logger LOGGER = LogManager.getLogger(ConsoleMenu.class);
    private static final ResultCollector result = new ResultCollector();

    public ConsoleMenu runMainMenu() {
        int answer = drawAnyMenuAndChooseMenuItem("MAIN MENU:", MainMenu.values());
        switch (answer) {
            case (1) -> {
                return runUserMenu();
            }
            case (2) -> {
                return authentication();
            }
            default -> {
                return tearDown();
            }
        }
    }

    private ConsoleMenu runUserMenu() {
        int answer = drawAnyMenuAndChooseMenuItem("USER MENU:", UserMenu.values());
        switch (answer) {
            case (1) -> {
                PRINT2LN.info("CHOICE OF ROUTE...");
                // TODO: Methods to:
                // TODO: - choose direction
                // TODO: - get and print routes collections by Floyd
                // TODO: - record routes collections to RouteCollector
                // TODO: - record RouteCollector to ResultCollector
                return runUserMenu();
            }
            case (2) -> {
                return runMainMenu();
            }
            default -> {
                return tearDown();
            }
        }
    }

    private ConsoleMenu runAdminMenu() {
        int answer = drawAnyMenuAndChooseMenuItem("ADMIN MENU:", AdminMenu.values());
        switch (answer) {
            case (1) -> {
                return runAdminCompanyMenu();
            }
            case (2) -> {
                return runAdminAirlineMenu();
            }
            case (3) -> {
                return runAdminRouteMenu();
            }
            case (4) -> {
                return runMainMenu();
            }
            default -> {
                return tearDown();
            }
        }
    }

    private ConsoleMenu runAdminCompanyMenu() {
        int answer = drawAnyMenuAndChooseMenuItem("ADMIN COMPANY MENU:", AdminCompanyMenu.values());
        switch (answer) {
            case (1) -> {
                PRINT2LN.info("SHOWING ALL COMPANIES...");
                // TODO: Method to show all companies
                return runAdminCompanyMenu();
            }
            case (2) -> {
                PRINT2LN.info("CREATING COMPANY...");
                // TODO: Method to create new company
                return runAdminCompanyMenu();
            }
            case (3) -> {
                PRINT2LN.info("UPDATING COMPANY...");
                // TODO: Method to update existing company
                return runAdminCompanyMenu();
            }
            case (4) -> {
                PRINT2LN.info("DELETING COMPANY...");
                // TODO: Method to delete existing company
                return runAdminCompanyMenu();
            }
            case (5) -> {
                return runAdminMenu();
            }
            default -> {
                return tearDown();
            }
        }
    }

    private ConsoleMenu runAdminAirlineMenu() {
        int answer = drawAnyMenuAndChooseMenuItem("ADMIN AIRLINE MENU:", AdminAirlineMenu.values());
        switch (answer) {
            case (1) -> {
                PRINT2LN.info("SHOWING ALL AIRLINES...");
                // TODO: Method to show all airlines
                return runAdminAirlineMenu();
            }
            case (2) -> {
                PRINT2LN.info("CREATING AIRLINE...");
                // TODO: Method to create new airline
                return runAdminAirlineMenu();
            }
            case (3) -> {
                PRINT2LN.info("UPDATING AIRLINE...");
                // TODO: Method to update existing airline
                return runAdminAirlineMenu();
            }
            case (4) -> {
                PRINT2LN.info("DELETING AIRLINE...");
                // TODO: Method to delete existing airline
                return runAdminAirlineMenu();
            }
            case (5) -> {
                return runAdminMenu();
            }
            default -> {
                return tearDown();
            }
        }
    }

    private ConsoleMenu runAdminRouteMenu() {
        int answer = drawAnyMenuAndChooseMenuItem("ADMIN ROUTE MENU:", AdminRouteMenu.values());
        switch (answer) {
            case (1) -> {
                PRINT2LN.info("SHOWING ALL ROUTES...");
                // TODO: Method to show all routes
                return runAdminRouteMenu();
            }
            case (2) -> {
                PRINT2LN.info("CREATING ROUTE...");
                // TODO: Method to create new route
                return runAdminRouteMenu();
            }
            case (3) -> {
                PRINT2LN.info("UPDATING ROUTE...");
                // TODO: Method to update existing route
                return runAdminRouteMenu();
            }
            case (4) -> {
                PRINT2LN.info("DELETING ROUTE...");
                // TODO: Method to delete existing route
                return runAdminRouteMenu();
            }
            case (5) -> {
                return runAdminMenu();
            }
            default -> {
                return tearDown();
            }
        }
    }

    private int drawAnyMenuAndChooseMenuItem(String title, IMenu[] menuItems) {
        int index = 1;
        PRINT2LN.info(title);
        for (IMenu item : menuItems) {
            PRINTLN.info(String.format("[%d]: %s", index, item.getTitle()));
            index++;
        }
        return RequestMethods.getNumberFromChoice("menu item number", index - 1);
    }

    private ConsoleMenu tearDown() {
        RequestMethods.closeScanner();
        if (result.getResult().size() > 0) {
            // TODO: Method to record ResultCollector to JSON file
            PRINTLN.info("[Info]: Result file was written!");
        } else {
            PRINTLN.info("[Info]: Result file was not written because there were no actions!");
        }
        PRINTLN.info("GOOD BYE!");
        return null;
    }

    private ConsoleMenu authentication() {
        PRINT2LN.info("AUTHENTICATION");
        String password = RequestMethods.getStringValueFromConsole("admin password");
        Properties property = new Properties();
        // You need to create file "config.properties" with variable "admin.password = <YOUR PASSWORD>"
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            property.load(fis);
            if (password.equals(property.getProperty("admin.password"))) {
                PRINTLN.info("[Info]: Password is correct!");
                return runAdminMenu();
            }
        } catch (IOException e) {
            throw new RuntimeException("You have been problem with reading from property file!", e);
        }
        LOGGER.error("[Warning]: Password is incorrect!");
        return runMainMenu();
    }
}
