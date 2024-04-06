package ru.itis.inf304.lab5.transport.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Vehicle {
    private String type;
    private Properties properties;
    private List<Feature> features;

    public Properties getProperties() {
        return properties;
    }

    public List<Feature> getFeatures() {
        return features;
    }
}

