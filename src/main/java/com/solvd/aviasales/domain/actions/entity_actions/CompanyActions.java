package com.solvd.aviasales.domain.actions.entity_actions;

import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.temporary.TempMethods;

import java.util.List;

import static com.solvd.aviasales.util.Printers.*;

public class CompanyActions implements IEntityActions {

    @Override
    public void showEntityEntries() {
        // TODO: Change string
//        List<Company> companies = new CompanyServiceImpl().getAll();
        List<Company> companies = TempMethods.getAllCompanies();
        PRINT2LN.info("ALL COMPANIES:");
        if (companies.size() > 0) {
            companies.forEach(company -> {
                PRINTLN.info(String.format("%s\n\tAIRLINES:", company));
                if (company.getAirlines().size() > 0) {
                    company.getAirlines().forEach(airline -> {
                        PRINTLN.info(String.format("\t- %s", airline));
                        if (airline.getRoutes().size() > 0) {
                            PRINTLN.info("\t\tROUTES:");
                            airline.getRoutes().forEach(route -> PRINTLN.info(String.format("\t\t- %s", route)));
                        } else {
                            PRINTLN.info("\t\t(no routes)");

                        }
                    });
                } else {
                    PRINTLN.info("\t(no airlines)");
                }
            });
        } else {
            PRINTLN.info("(no companies)");
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
