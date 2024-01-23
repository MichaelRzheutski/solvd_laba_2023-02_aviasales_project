package com.solvd.aviasales.domain.actions.entity_actions;

import com.solvd.aviasales.util.functional_interfaces.IPrintAsMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.aviasales.util.Printers.*;

public interface IEntityActions {
    Logger LOGGER = LogManager.getLogger(IEntityActions.class);
    IPrintAsMenu<Integer, String> printAsMenu = (index, line) -> PRINTLN.info(String.format("[%d]: %s", index, line));

    void showEntityEntries();
    void registerEntityEntry();
    void removeEntityEntry();
    void updateEntityEntry();
}
