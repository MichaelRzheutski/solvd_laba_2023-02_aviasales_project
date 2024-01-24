package com.solvd.aviasales.domain.actions.entity_actions;

import com.solvd.aviasales.domain.structure.Company;
import com.solvd.aviasales.service.CompanyService;
import com.solvd.aviasales.util.console_menu.RequestMethods;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.aviasales.util.Printers.*;

public class CompanyActions implements IEntityActions {

    @Override
    public void showEntityEntries() {
        List<Company> companies = new CompanyService().getAll();
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
        PRINT2LN.info("REGISTERING COMPANY");
        CompanyService companyService = new CompanyService();
        String title = RequestMethods.getStringValueFromConsole("company title");
        Company company = new Company(title);
        companyService.save(company);
        PRINT2LN.info(String.format("COMPANY %s WAS REGISTERED", title));
    }

    @Override
    public void removeEntityEntry() {
        PRINT2LN.info("REMOVING COMPANY");
        CompanyService companyService = new CompanyService();
        Company company = getExistingCompanyFromConsole();
        companyService.delete(company.getId());
        PRINT2LN.info(String.format("COMPANY %s WAS DELETED", company.getTitle()));
    }

    @Override
    public void updateEntityEntry() {
        PRINT2LN.info("UPDATING COMPANY");
        CompanyService companyService = new CompanyService();
        Company company = getExistingCompanyFromConsole();
        Field field = getCompanyClassFieldFromConsole();
        if (field.getName().equals("title")) {
            company.setTitle(RequestMethods.getStringValueFromConsole("new value"));
        }
        companyService.update(company);
        PRINT2LN.info(String.format("COMPANY %s WAS UPDATED", company.getTitle()));
    }

    protected static Company getExistingCompanyFromConsole() {
        CompanyService companyService = new CompanyService();
        List<Company> companies = companyService.getAll();
        PRINTLN.info("Choose the company:");
        int index = 1;
        for (Company company : companies) {
            printAsMenu.print(index, company.getTitle());
            index++;
        }
        return companies.get(RequestMethods.getNumberFromChoice("company", index - 1) - 1);
    }

    private static Field getCompanyClassFieldFromConsole() {
        int index = 1;
        PRINTLN.info("Choose the field for update:");
        List<Field> allCompanyFields = List.of(Company.class.getDeclaredFields());
        List<Field> companyFields = new ArrayList<>();
        for (Field companyField : allCompanyFields) {
            if (!companyField.getName().equals("id") && !companyField.getName().equals("airlines")) {
                printAsMenu.print(index, companyField.getName());
                companyFields.add(companyField);
                index++;
            }
        }
        return companyFields.get(RequestMethods.getNumberFromChoice("field number", index - 1) - 1);
    }
}
