package ro.ulbs.paradigme.lab10.dataprocessing;

import ro.ulbs.paradigme.lab10.storage.SensorData;

public class BasicStepCountStrategy implements StepCountStrategy {
    int suma=0;
    @Override
    public void consumeMessage(SensorData sample) {
        suma+= sample.getStepsCount();
    }

    @Override
    public int getTotalSteps() {
        return suma;
    }

    @Override
    public String getStrategyDescription() {
        return " 'BasicStepCountStrategy' ";
    }
}
