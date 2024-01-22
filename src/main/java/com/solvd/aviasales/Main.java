package com.solvd.aviasales;

import com.solvd.aviasales.temporary.RouteTempMethods;
import org.apache.log4j.BasicConfigurator;

public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        // run app method

        // You can delete this code - checking toString() methods from hierarchy:
//        TempMethods.checkingToStringMethodsFromHierarchy();

        // You can delete this code - checking CollectorActions methods:
//        TempMethods.checkingCollectorActionsMethods();

        // Methods for testing
        RouteTempMethods.printAviasales();
    }
}