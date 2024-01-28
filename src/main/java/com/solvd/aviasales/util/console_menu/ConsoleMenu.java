package com.solvd.aviasales.util.console_menu;

import com.solvd.aviasales.domain.actions.CollectorActions;
import com.solvd.aviasales.domain.actions.UserActions;
import com.solvd.aviasales.domain.session.ResultCollector;
import com.solvd.aviasales.domain.session.RouteCollector;
import com.solvd.aviasales.util.JsonParser;
import com.solvd.aviasales.util.XmlParserJAXB;
import com.solvd.aviasales.util.ZipArchiver;
import com.solvd.aviasales.util.console_menu.menu_enums.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.solvd.aviasales.util.Printers.PRINT2LN;
import static com.solvd.aviasales.util.Printers.PRINTLN;

public class ConsoleMenu {
    protected static final Logger LOGGER = LogManager.getLogger(ConsoleMenu.class);
    protected static EntityActionsService ENTITY_ACTIONS_SERVICE = EntityActionsService.getInstance();
    private static final ResultCollector RESULT = new ResultCollector();

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
                RouteCollector collector = UserActions.getRouteCollectionFromConsole();
                RESULT.addRouteCollectionToResult(collector);
                CollectorActions.showRouteCollection(collector);
                return runUserMenu();
            }
            case (2) -> {
                UserActions.chooseFinishRouteCollection(RESULT);
                return runUserMenu();
            }
            case (3) -> {
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
                ENTITY_ACTIONS_SERVICE.assignEntry("COMPANY");
                return runAdminCompanyMenu();
            }
            case (2) -> {
                ENTITY_ACTIONS_SERVICE.assignEntry("AIRLINE");
                return runAdminAirlineMenu();
            }
            case (3) -> {
                ENTITY_ACTIONS_SERVICE.assignEntry("ROUTE");
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
                ENTITY_ACTIONS_SERVICE.getEntityActions().showEntityEntries();
                return runAdminCompanyMenu();
            }
            case (2) -> {
                ENTITY_ACTIONS_SERVICE.getEntityActions().registerEntityEntry();
                return runAdminCompanyMenu();
            }
            case (3) -> {
                ENTITY_ACTIONS_SERVICE.getEntityActions().updateEntityEntry();
                return runAdminCompanyMenu();
            }
            case (4) -> {
                ENTITY_ACTIONS_SERVICE.getEntityActions().removeEntityEntry();
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
                ENTITY_ACTIONS_SERVICE.getEntityActions().showEntityEntries();
                return runAdminAirlineMenu();
            }
            case (2) -> {
                ENTITY_ACTIONS_SERVICE.getEntityActions().registerEntityEntry();
                return runAdminAirlineMenu();
            }
            case (3) -> {
                ENTITY_ACTIONS_SERVICE.getEntityActions().updateEntityEntry();
                return runAdminAirlineMenu();
            }
            case (4) -> {
                ENTITY_ACTIONS_SERVICE.getEntityActions().removeEntityEntry();
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
                ENTITY_ACTIONS_SERVICE.getEntityActions().showEntityEntries();
                return runAdminRouteMenu();
            }
            case (2) -> {
                ENTITY_ACTIONS_SERVICE.getEntityActions().registerEntityEntry();
                return runAdminRouteMenu();
            }
            case (3) -> {
                ENTITY_ACTIONS_SERVICE.getEntityActions().updateEntityEntry();
                return runAdminRouteMenu();
            }
            case (4) -> {
                ENTITY_ACTIONS_SERVICE.getEntityActions().removeEntityEntry();
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
        File generatedJsonFile;
        File generatedXmlFile;
        RequestMethods.closeScanner();
        if (RESULT.getResult().size() > 0) {
            CollectorActions.showResultCollection(RESULT);
            generatedJsonFile = JsonParser.saveToJson(RESULT);
            generatedXmlFile = XmlParserJAXB.saveToXml(RESULT);
            ZipArchiver.archiveFiles(generatedJsonFile, generatedXmlFile);
        } else {
            PRINT2LN.info("[Info]: Result file was not written because there were no actions!");
        }
        PRINTLN.info("GOOD BYE!");
        return null;
    }

    private ConsoleMenu authentication() {
        PRINT2LN.info("AUTHENTICATION");
        String password = RequestMethods.getStringValueFromConsole("admin password");
        Properties property = new Properties();
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
