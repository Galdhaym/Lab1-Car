package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CarCompany {
    private ArrayList<Car> cars = new ArrayList<>();

    public CarCompany(){

    }

    public void add(Car footballer) {
        cars.add(footballer);
    }

    public int size() {
        return cars.size();
    }

    public static void printCarData(CarCompany company){
        System.out.println("Все машины, зарегистрированные более года назад и имеющие грузоподъёмность более 3-х тонн.");
        int i = 0;
        LocalDate currentDate = LocalDate.now();
        for(Car car: company.cars){
            int age = getTotalYears(car.getRegistrationDate(), currentDate);
            int liftingCapacity = car.getLiftingCapacity();

            if(age > 1 && liftingCapacity > 3) {
                System.out.println("Машина №"+ (i+1) + "\n"+ car);
                i++;
            }
        }
    }

    private static int getTotalYears(LocalDate startDate, LocalDate finishDate) {
        Period period = Period.between(startDate, finishDate);
        return period.getYears();
    }
}
