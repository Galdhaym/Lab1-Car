package com.company;

import com.google.gson.Gson;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {

    public static final String BACKUP_PATH = "C:\\Users\\Дима\\IdeaProjects\\Lab1-Car\\src\\resources\\";

    public static boolean createBackUpCopyOfFile(File file) throws Exception {
        Path path = Paths.get(BACKUP_PATH + file.getName().replace(".txt", "") + "_copy.txt");
        if(!Files.exists(path)) {
            return false;
        }
        Files.copy(file.toPath(), path, REPLACE_EXISTING);
        return true;
    }

    public static void restoreStateFromBackUp(File file) throws Exception {
        Path path = Paths.get(BACKUP_PATH + file.getName().replace(".txt", "") + "_copy.txt");
        if(!Files.exists(path)) {
            return;
        }
        Files.copy(path, file.toPath(), REPLACE_EXISTING);
    }

    public static void serializeJson(Car car){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(car);
        System.out.println(jsonObject);
        Car resultCar = gson.fromJson(jsonObject, Car.class);
        System.out.println(resultCar);
    }

    public static void main(String[] args) throws Exception {
        Car car1 = new Car("Toyota Camry", "Toyota", 2, 1982, LocalDate.of(2000, 6, 10));
        Car car2 = new Car("SLR Racer", "Mercedes-Benz", 1, 1955, LocalDate.of(1958, 4, 7));
        boolean value;
        File file = new File(BACKUP_PATH + "text.txt");
        file.createNewFile();
        try (ObjectSerializer objectSerializer = new ObjectSerializer(file)) {
            objectSerializer.save(car1);
            value = createBackUpCopyOfFile(file);
            objectSerializer.save(car2);
            Car car1Before = (Car) objectSerializer.load();
            Car car2Before = (Car) objectSerializer.load();
            System.out.println("До бекапа: ");
            System.out.println(car1Before);
            System.out.println(car2Before);
        }
        try (ObjectSerializer restoreObjectSerializer = new ObjectSerializer(file)) {
            if (value) {
                restoreStateFromBackUp(file);
            }
            Car car1After = (Car) restoreObjectSerializer.load();
            System.out.println("После бекапа: ");
            System.out.println(car1After);
        }
    }
}
