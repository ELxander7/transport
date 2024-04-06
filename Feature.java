package ru.itis.inf304.lab5.transport.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feature {
    private Geometry geometry;
    private FeatureProperty properties;

    public Geometry getGeometry() {
        return geometry;
    }

}
