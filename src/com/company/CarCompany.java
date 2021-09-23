package com.company;

import java.time.LocalDate;
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
                System.out.println("Машина №" + (i + 1) + ":");
                System.out.println("Марка машины: " + car.getCarModel());
               System.out.println("Производитель: " + car.getProducer());
                System.out.println("Грузоподьемность: " + car.getLiftingCapacity());
                System.out.println("Год выпуска: " + car.getYearOfProduction());
                System.out.println("Дата регистрации(в формате дд.мм.гггг): " + DateTimeFormatter.ofPattern("dd.MM.yyyy").format(car.getRegistrationDate()));
            }
            i++;
        }
    }

    private static int getTotalYears(LocalDate startDate, LocalDate finishDate) {
        int years = finishDate.getYear() -  startDate.getYear();
        if(startDate.getMonth().getValue() > finishDate.getMonth().getValue()){
            years--;
        }
        else if(startDate.getDayOfMonth() > finishDate.getDayOfMonth()){
            years--;
        }
        return years;
    }
}
