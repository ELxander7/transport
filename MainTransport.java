package ru.itis.inf304.lab5.transport.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainTransport {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            TransportDataBase dataBase =
                    mapper.readValue(new File("transport.json"), TransportDataBase.class);

            if (dataBase != null) {
                dataBase.getData().getVehicles().stream().filter(v -> v.getProperties().getVehicleMetaData().getTransport().getType().equals("bus"));
            }
            //1
            List<String> result1 = dataBase.getData().getVehicles().stream().map(v -> v.getProperties().getVehicleMetaData().getTransport().getType()).distinct().toList();
            System.out.println(result1);

            //2
            List<Vehicle> result2 = dataBase.getData().getVehicles().stream().filter(v -> v.getProperties().getVehicleMetaData().getTransport().getName().equals("55")).toList();
            System.out.println(result2.size());

            //3
            Map<String, Integer> map = dataBase.getData().getVehicles().stream().collect(Collectors.toMap(v -> v.getProperties().getVehicleMetaData().getId(), v -> v.getFeatures().stream().mapToInt(f->f.getGeometry().getCoordinates().size()).sum()));
            System.out.println(map.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}




















    /* public static void findTransportInTransportDataBase(List<Vehicle> vehicles){
        vehicles.stream().map(vehicle -> vehicle.getProperties().getVehicleMetaData().getTransport().getType().distinct.)
    } */