package com.circle;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.codahale.metrics.MetricRegistry.name;

/**
 * Created by ThinkPad on 13.06.2017.
 */

@RestController
public class MeasurementEndpoint {
    private final MeasurementRepository measurementRepository;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(MeasurementEndpoint.class);
    private final MetricRegistry metrics;
    private Timer responses;

    @Autowired
    public MeasurementEndpoint(MeasurementRepository measurementRepository, MetricRegistry metrics) {
        this.measurementRepository = measurementRepository;
        this.metrics = metrics;
        this.responses =  metrics.timer(name(MeasurementEndpoint.class, "responses"));

    }

    @RequestMapping(value = "/measurements", method = RequestMethod.GET)
    public List<Measurement> getMeasurements() throws InterruptedException {
        final Timer.Context context = responses.time();
        try {
            return measurementRepository.getMeasurements();
        } finally {
            context.stop();
        }
    }

    @RequestMapping(value = "/measurements/{id}", method = RequestMethod.GET)
    public Measurement getUser(@PathVariable(name = "id") Integer id) {
         return measurementRepository.getMeasurement(id);
    }


    @RequestMapping(value = "/measurement", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public List<Measurement> add(@RequestBody Measurement measurement) {
        return measurementRepository.addMeasurement(measurement);
    }
}
