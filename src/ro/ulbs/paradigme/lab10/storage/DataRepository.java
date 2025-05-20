package ro.ulbs.paradigme.lab10.storage;


import ro.ulbs.paradigme.lab10.dataprocessing.StepCountStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Persists sensor data.
 */
public class DataRepository {
    private List<SensorData> records = new ArrayList<>();
    private static DataRepository instance=null;
    private DataRepository() {}
    public static DataRepository getInstance(){
        if(instance==null) {
            instance=new DataRepository();
        }
        return instance;
    }
    public void addData(SensorData dataRecord){
        records.add(dataRecord);
    }

    public List<SensorData> getRecords() {
        return records;
    }
}


