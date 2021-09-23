package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static LocalDate parseStringToLocalDateFormat(String str){
        String[] strDate = str.split("\\.");
        LocalDate date;
        if(strDate.length == 3){
            int day = Integer.parseInt(strDate[0]);
            int month = Integer.parseInt(strDate[1]);
            int year = Integer.parseInt(strDate[2]);
            date = LocalDate.of(year, month , day);
        }
        else{
            throw new Error("Incorrect date format.");
        }
        return date;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarCompany carCompany = new CarCompany();

        Car car;
        LocalDate registrationDate;
        System.out.print("Введите количество машин:");
        int length = scanner.nextInt();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                System.out.println("Машина №" + (i + 1) + ":");
                car = new Car();
                System.out.print("Марка машины: ");
                car.setCarModel(scanner.next());
                System.out.print("Производитель: ");
                car.setProducer(scanner.next());
                System.out.print("Грузоподьемность: ");
                car.setLiftingCapacity(scanner.nextInt());
                System.out.print("Год выпуска: ");
                car.setYearOfProduction(scanner.nextInt());
                System.out.print("Дата регистрации(в формате дд.мм.гггг): ");
                registrationDate = parseStringToLocalDateFormat(scanner.next());
                car.setRegistrationDate(registrationDate);
                carCompany.add(car);
            }

            CarCompany.printCarData(carCompany);
        }
        else{
            System.out.print("Кол-во машин должно быть > 0");
        }
    }
}
