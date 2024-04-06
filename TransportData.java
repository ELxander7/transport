package ru.itis.inf304.lab5.transport.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransportData {
    private List<Vehicle> vehicles;
    private RegionInfo regionInfo;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}