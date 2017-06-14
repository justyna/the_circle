package com.circle;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ThinkPad on 13.06.2017.
 */

@Service
public class MeasurementRepository {

    List<Measurement> measurements = new ArrayList<>();

    public MeasurementRepository() {
        this.measurements.add(new Measurement(1, 101, 36.6, 80.7, 100.00));
        this.measurements.add(new Measurement(2, 102, 38.7, 101.7, 90.00));
        this.measurements.add(new Measurement(3, 101, 40.6, 80.7, 100.00));
        this.measurements.add(new Measurement(4, 102, 38.6, 89.7, 150.00));
        this.measurements.add(new Measurement(5, 101, 41.6, 80.7, 100.00));
        this.measurements.add(new Measurement(6, 103, 38.7, 101.7, 90.00));
        this.measurements.add(new Measurement(7, 104, 40.6, 80.7, 100.00));
        this.measurements.add(new Measurement(8, 105, 38.6, 89.7, 150.00));
    }

    List<Measurement> getMeasurements() throws InterruptedException {
        Random r = new Random();
        int latency = r.nextInt(7000);
        Thread.sleep(latency);
        return measurements;
    }

    Measurement getMeasurement(Integer id) {
        return measurements.get(id);
    }

    List<Measurement> addMeasurement(Measurement measurement) {
        this.measurements.add(measurement);
        return measurements;
    }
}
