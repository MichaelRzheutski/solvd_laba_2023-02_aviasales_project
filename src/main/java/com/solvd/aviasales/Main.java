package com.solvd.aviasales;


import com.solvd.aviasales.temporary.Tester;
import com.solvd.aviasales.util.console_menu.ConsoleMenu;

import com.solvd.aviasales.temporary.RouteTempMethods;
import org.apache.log4j.BasicConfigurator;

public class Main {

    public static void main(String[] args) {
        new ConsoleMenu().runMainMenu();

        BasicConfigurator.configure();

        Tester.perform();

        // Methods for testing
//        RouteTempMethods.printAviasales();
    }
}