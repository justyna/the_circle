package com.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by ThinkPad on 13.06.2017.
 */

@Controller
public class MeasurementEndpoint {
    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementEndpoint(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @RequestMapping("/measurements")
    public List<Measurement> getMeasurements() throws InterruptedException {
        return measurementRepository.getMeasurements();
    }

    @RequestMapping("/measurements/{id}")
    public Measurement getUser(@PathVariable(name = "id") Integer id) {
        return measurementRepository.getMeasurement(id);
    }


    @RequestMapping(value = "/measurements", method = RequestMethod.POST,
            consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
    public List<Measurement> add(@RequestBody Measurement measurement) {
        return measurementRepository.addMeasurement(measurement);
    }
}
