package com.solvd.aviasales.domain.actions.entity_actions;

import com.solvd.aviasales.domain.structure.Airline;
import com.solvd.aviasales.temporary.TempMethods;

import java.util.List;

import static com.solvd.aviasales.util.Printers.*;

public class AirlineActions implements IEntityActions {

    @Override
    public void showEntityEntries() {
        // TODO: Change string
//        List<Airline> airlines = new AirlineServiceImpl().getAll();
        List<Airline> airlines = TempMethods.getAllAirlines();
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
        // TODO: Implement method
    }

    @Override
    public void removeEntityEntry() {
        // TODO: Implement method
    }

    @Override
    public void updateEntityEntry() {
        // TODO: Implement method
    }
}
