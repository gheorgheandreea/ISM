package ro.ulbs.paradigme.lab10.dataprocessing;

import ro.ulbs.paradigme.lab10.storage.DataRepository;
import ro.ulbs.paradigme.lab10.storage.SensorData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteredStepCountStrategy implements StepCountStrategy {
  int suma=0;
    private final DataRepository repo = DataRepository.getInstance();
    @Override
    public void consumeMessage(SensorData sample) {

         long one_minute_ago = System.currentTimeMillis() - 60000;
        List<SensorData> lastMinuteList = repo.getRecords().stream()
                .filter(r -> r.getTimestamp() >= one_minute_ago && r.getTimestamp() < sample.getTimestamp())
                .collect(Collectors.toList());
        int stepsInLastMinute = lastMinuteList.stream()
                .filter(r -> r.getStepsCount() > 0)
                .mapToInt(SensorData::getStepsCount)
                .sum();

        if(sample.getStepsCount()>0 &&stepsInLastMinute <= 1000){
            suma+=sample.getStepsCount();
        }
    }

    @Override
    public int getTotalSteps() {
        return suma;
    }

    @Override
    public String getStrategyDescription() {
        return " 'FilteredStepCountStrategy' ";
    }
}
