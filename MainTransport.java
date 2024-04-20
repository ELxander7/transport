package ru.itis.inf304.lab5.transport.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.Instant;


public class MainTransport {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            TransportDataBase dataBase =
                    mapper.readValue(new File("transport.json"), TransportDataBase.class);

            //1. Определить какой транспорт есть в базе данных (троллейбус, автобус...)
            dataBase.getData().getVehicles().stream().map(vehicle -> vehicle.getProperties().
                    getVehicleMetaData().getTransport().getType()).distinct().forEach(System.out::println);


            //2. Определить количество транспорта определенного маршрута на линии
            System.out.println("Задание 2");
            System.out.println(dataBase.getData().getVehicles().stream().filter(vehicle -> vehicle.getProperties().
                    getVehicleMetaData().getTransport().getName().equals("55")).count());

            //3. Создать Map<>  , показывающий транспортное средство и количество сообщений о своих координатах
            System.out.println("Задание 3");
            Map<String, Integer> map3 =dataBase.getData().getVehicles().stream().collect(Collectors.
                    toMap(vehicle -> vehicle.getProperties().getVehicleMetaData().getId(),vehicle -> vehicle.getFeatures().
                            stream().mapToInt(f -> f.getGeometry().getCoordinates().size()).sum()));
            System.out.println(map3.toString());

            System.out.println();

            //4. Вывести номер, тип, id транспорта, отсортировав в порядке возрастания номера маршрута
            System.out.println("Задание 4");
            dataBase.getData().getVehicles().stream().sorted(Comparator.
                    comparing(p -> p.getProperties().getVehicleMetaData().getTransport().getName())).distinct().forEach(vehicle -> {
                    System.out.print(vehicle.getProperties().getVehicleMetaData().getTransport().getName() + " " );
                    System.out.print(vehicle.getProperties().getVehicleMetaData().getTransport().getType() + " " );
                    System.out.print(vehicle.getProperties().getVehicleMetaData().getTransport().getId() + " " );
                    } ) ;

            System.out.println();
            System.out.println();

            //5. Вывести для каждого транспортного средства массив из времени  (dd.MM.yyyy HH:mm:ss) (Properties)
            System.out.println("Задание 5");
            dataBase.getData().getVehicles().stream().flatMapToLong(v -> v.getFeatures().stream()
                    .mapToLong(e->e.getProperties().getTrajectorySegmentMetaData().getTime())).forEach(num ->
                    System.out.println(Date.from(Instant.ofEpochSecond(num))));


            System.out.println();
            System.out.println();

            //6. Вывести id только трамваев, автобусов, троллейбусов
            System.out.println("Задание 6");
            System.out.println("автобус");
            dataBase.getData().getVehicles().stream().filter(vehicle -> vehicle.
                    getProperties().getVehicleMetaData().getTransport().getType().equals("bus")).forEach(vehicle ->
                    System.out.print(vehicle.getProperties().getVehicleMetaData().getTransport().getId() + " "));


            System.out.println();
            System.out.println("трамвай");
            dataBase.getData().getVehicles().stream().filter(vehicle -> vehicle.
                    getProperties().getVehicleMetaData().getTransport().getType().equals("tramway")).forEach(vehicle ->
                    System.out.print(vehicle.getProperties().getVehicleMetaData().getTransport().getId() + " "));


            System.out.println();
            System.out.println("троллейбус");
            dataBase.getData().getVehicles().stream().filter(vehicle -> vehicle.
                    getProperties().getVehicleMetaData().getTransport().getType().equals("trolleybus")).forEach(vehicle ->
                    System.out.print(vehicle.getProperties().getVehicleMetaData().getTransport().getId() + " "));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}