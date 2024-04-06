package ru.itis.inf304.lab5.transport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleMetaData {
    private String id;
    @JsonProperty("Transport")
    private Transport transport;

    public Transport getTransport() {
        return transport;
    }

    public String getId() {
        return id;
    }
}
