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

    private List<Measurement> measurements = new ArrayList<>();

    public MeasurementRepository() {
        this.measurements.add(new Measurement(0, 101, 36.6, 80.7, 100.00));
        this.measurements.add(new Measurement(1, 102, 38.7, 101.7, 90.00));
        this.measurements.add(new Measurement(2, 101, 40.6, 80.7, 100.00));
        this.measurements.add(new Measurement(3, 102, 38.6, 89.7, 150.00));
        this.measurements.add(new Measurement(4, 101, 41.6, 80.7, 100.00));
        this.measurements.add(new Measurement(5, 103, 38.7, 101.7, 90.00));
        this.measurements.add(new Measurement(6, 104, 40.6, 80.7, 100.00));
        this.measurements.add(new Measurement(7, 105, 38.6, 89.7, 150.00));
    }

    List<Measurement> getMeasurements() throws InterruptedException {
        Random r = new Random();
        int latency = r.nextInt(7000);
        Thread.sleep(latency);
        return measurements;
    }

    Measurement getMeasurement(Integer id) {
        return measurements
                .stream()
                .filter( m -> m.getId().equals(id))
                .findFirst()
                .orElse(new Measurement(null, null, null, null, null));
    }

    List<Measurement> addMeasurement(Measurement measurement) {
        this.measurements.add(measurement);
        return measurements;
    }
}
