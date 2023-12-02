package enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public enum AmbulancesModel {

    Ford("Ford"),
    Chevy("Chevy"),
    Honda("Honda"),
    Subaru("Subaru");

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());


    private final String model;

    AmbulancesModel(String model) {
        this.model = model;
    }

    static {
        LOGGER.info("Initializing AmbulanceModel enum");
    }

    public String getModelName() {
        return model;
    }
}
