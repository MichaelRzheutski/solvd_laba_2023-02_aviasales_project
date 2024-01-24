package com.solvd.aviasales.domain.actions.entity_actions;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.service.AirlineService;
import com.solvd.aviasales.util.console_menu.RequestMethods;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.aviasales.util.Printers.*;

public class AirlineActions implements IEntityActions {

    @Override
    public void showEntityEntries() {
        List<Airline> airlines = new AirlineService().getAll();
        PRINT2LN.info("ALL AIRLINES:");
        if (airlines.size() > 0) {
            airlines.forEach(airline -> {
                PRINTLN.info(String.format("%s\n\tROUTES:", airline));
                if (airline.getRoutes().size() > 0) {
                    airline.getRoutes().forEach(route -> PRINTLN.info(String.format("\t- %s", route)));
                } else {
                    PRINTLN.info("\t(no routes)");
                }
            });
        } else {
            PRINTLN.info("(no airlines)");
        }
    }

    @Override
    public void registerEntityEntry() {
        PRINT2LN.info("REGISTERING AIRLINE");
        AirlineService airlineService = new AirlineService();
        String title = RequestMethods.getStringValueFromConsole("airline title");
        Company company = CompanyActions.getExistingCompanyFromConsole();
        Airline airline = new Airline(title, company);
        airlineService.save(airline);
        PRINT2LN.info(String.format("AIRLINE %s WAS REGISTERED", title));
    }

    @Override
    public void removeEntityEntry() {
        PRINT2LN.info("REMOVING AIRLINE");
        AirlineService airlineService = new AirlineService();
        Airline airline = getExistingAirlineFromConsole();
        airlineService.delete(airline.getId());
        PRINT2LN.info(String.format("AIRLINE %s WAS DELETED", airline.getTitle()));
    }

    @Override
    public void updateEntityEntry() {
        PRINT2LN.info("UPDATING AIRLINE");
        AirlineService airlineService = new AirlineService();
        Airline airline = getExistingAirlineFromConsole();
        Field field = getAirlineClassFieldFromConsole();
        switch (field.getName()) {
            case ("title") -> airline.setTitle(RequestMethods.getStringValueFromConsole("new value"));
            case ("company") -> airline.setCompany(CompanyActions.getExistingCompanyFromConsole());
        }
        airlineService.update(airline);
        PRINT2LN.info(String.format("AIRLINE %s WAS UPDATED", airline.getTitle()));
    }

    protected static Airline getExistingAirlineFromConsole() {
        AirlineService airlineService = new AirlineService();
        List<Airline> airlines = airlineService.getAll();
        PRINTLN.info("Choose the airline:");
        int index = 1;
        for (Airline airline : airlines) {
            printAsMenu.print(index, airline.getTitle());
            index++;
        }
        return airlines.get(RequestMethods.getNumberFromChoice("airline", index - 1) - 1);
    }

    private static Field getAirlineClassFieldFromConsole() {
        int index = 1;
        PRINTLN.info("Choose the field for update:");
        List<Field> allAirlineFields = List.of(Airline.class.getDeclaredFields());
        List<Field> airlineFields = new ArrayList<>();
        for (Field airlineField : allAirlineFields) {
            if (!airlineField.getName().equals("id") && !airlineField.getName().equals("routes")) {
                printAsMenu.print(index, airlineField.getName());
                airlineFields.add(airlineField);
                index++;
            }
        }
        return airlineFields.get(RequestMethods.getNumberFromChoice("field number", index - 1) - 1);
    }
}
