package com.solvd.aviasales.domain.actions.entity_actions;

import com.solvd.aviasales.domain.structure.Route;
import com.solvd.aviasales.service.RouteService;

import java.util.List;

import static com.solvd.aviasales.util.Printers.*;

public class RouteActions implements IEntityActions {

    @Override
    public void showEntityEntries() {
        List<Route> routes = new RouteService().getAll();
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
