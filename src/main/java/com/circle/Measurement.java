package com.circle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ThinkPad on 13.06.2017.
 */
public class Measurement {
    private final Integer id;
    private final Integer userId;
    private final Double bodyTemperature;
    private final Double pulseRate;
    private final Double bloodPressure;

    @JsonCreator
    Measurement(@JsonProperty("id") Integer id, @JsonProperty("userId") Integer userId,
                @JsonProperty("bodyTemperature") Double bodyTemperature, @JsonProperty("pulseRate") Double pulseRate,
                @JsonProperty("bloodPressure") Double bloodPressure) {
        this.id = id;
        this.userId = userId;
        this.bodyTemperature = bodyTemperature;
        this.pulseRate = pulseRate;
        this.bloodPressure = bloodPressure;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Double getBodyTemperature() {
        return bodyTemperature;
    }

    public Double getPulseRate() {
        return pulseRate;
    }

    public Double getBloodPressure() {
        return bloodPressure;
    }
}
