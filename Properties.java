package ru.itis.inf304.lab5.transport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Properties {
    private String type;
    @JsonProperty("VehicleMetaData")
    private VehicleMetaData vehicleMetaData;

    public VehicleMetaData getVehicleMetaData() {
        return vehicleMetaData;
    }
}