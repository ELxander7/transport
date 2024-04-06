package ru.itis.inf304.lab5.transport.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransportDataBase {
    private TransportData data;

    public TransportData getData() {
        return data;
    }
}