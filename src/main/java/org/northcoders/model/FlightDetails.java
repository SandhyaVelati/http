package org.northcoders.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record FlightDetails(@JsonProperty("flightName")String flightName, String id, String scheduleDate, int terminal, String actualLandingTime,
                            Map<String,String> aircraftType ) {

    @Override
    public String toString() {
        return "FlightDetails{" +
                "flightName='" + flightName + '\'' +
                ", id='" + id + '\'' +
                ", scheduleDate='" + scheduleDate + '\'' +
                ", terminal=" + terminal +
                ", actualLandingTime='" + actualLandingTime + '\'' +
                ", aircraftType=" + aircraftType +
                '}';
    }
}
