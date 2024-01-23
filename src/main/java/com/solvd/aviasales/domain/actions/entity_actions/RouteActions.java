package com.solvd.aviasales.domain.actions.entity_actions;

import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.temporary.TempMethods;

import java.util.List;

import static com.solvd.aviasales.util.Printers.*;

public class RouteActions implements IEntityActions {

    @Override
    public void showEntityEntries() {
        // TODO: Change string
//        List<Route> routes = new RouteServiceImpl().getAll();
        List<Route> routes = TempMethods.getAllRoutes();
        PRINT2LN.info("ALL ROUTES:");
        if (routes.size() > 0) {
            routes.forEach(route -> PRINTLN.info(String.format("- %s", route)));
        } else {
            PRINTLN.info("(no routes)");
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
