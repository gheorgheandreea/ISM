package ro.ulbs.paradigme.lab10.main;

import ro.ulbs.paradigme.lab10.dataprocessing.BasicStepCountStrategy;
import ro.ulbs.paradigme.lab10.dataprocessing.FilteredStepCountStrategy;
import ro.ulbs.paradigme.lab10.dataprocessing.StepCountStrategy;
import ro.ulbs.paradigme.lab10.storage.SensorData;

public class Utils {
    public static final String BASIC_STRATEGY = "basic";
    public static final String FILTERED_STRATEGY = "filtered";

    public static int getClientId() {
        return 42;
    }
    public static StepCountStrategy getStrategy(String strategyType) {
        if(strategyType.equals(BASIC_STRATEGY)) {
            return new BasicStepCountStrategy();
        }
        else{
            return new FilteredStepCountStrategy();
        }
    }
}
