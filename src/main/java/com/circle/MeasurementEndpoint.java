package com.circle;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ThinkPad on 13.06.2017.
 */

@RestController
public class MeasurementEndpoint {
    private final MeasurementRepository measurementRepository;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(MeasurementEndpoint.class);

    @Autowired
    public MeasurementEndpoint(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @RequestMapping(value = "/measurements", method = RequestMethod.GET)
    public List<Measurement> getMeasurements() throws InterruptedException {
        long start = System.currentTimeMillis();
        final List<Measurement> measurements = measurementRepository.getMeasurements();
        logger.info("getMeasurements - {}", (System.currentTimeMillis() - start));
        return measurements;
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
