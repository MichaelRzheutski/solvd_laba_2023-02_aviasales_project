package com.solvd.aviasales.domain.actions.entity_actions;

import com.solvd.aviasales.util.functional_interfaces.IPrintAsMenu;

import static com.solvd.aviasales.util.Printers.*;

public interface IEntityActions {
    IPrintAsMenu<Integer, String> PRINT_AS_MENU = (index, line) -> PRINTLN.info(String.format("[%d]: %s", index, line));

    void showEntityEntries();
    void registerEntityEntry();
    void removeEntityEntry();
    void updateEntityEntry();
}
