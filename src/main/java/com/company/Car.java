package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Car implements Serializable {
    private String carModel;
    private String producer;
    private int liftingCapacity;
    private int yearOfProduction;
    private LocalDate registrationDate;

    public Car(String carModel, String producer, int liftingCapacity, int yearOfProduction, LocalDate registrationDate) {
        this.carModel = carModel;
        this.producer = producer;
        this.liftingCapacity = liftingCapacity;
        this.yearOfProduction = yearOfProduction;
        this.registrationDate = registrationDate;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        if(carModel != null && !carModel.isEmpty()) {
            this.carModel = carModel;
        }
        else{
            throw new Error("carModel must not be empty.");
        }
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        if(producer != null && !producer.isEmpty()) {
            this.producer = producer;
        }
        else{
            throw new Error("producer must not be empty.");
        }
    }

    public int getLiftingCapacity() {
        return liftingCapacity;
    }

    @Override
    public String toString() {
        return "Машина:" + "\n" +
                "Марка машины:" + carModel + "\n" +
                "Производитель:" + producer + "\n" +
                "Грузоподьемность:" + liftingCapacity + "\n" +
                "Год выпуска:" + yearOfProduction + "\n" +
                "Дата регистрации(в формате дд.мм.гггг) :" + DateTimeFormatter.ofPattern("dd.MM.yyyy").format(registrationDate);
    }

    public void setLiftingCapacity(int liftingCapacity) {
        if(liftingCapacity >= 0) {
            this.liftingCapacity = liftingCapacity;
        }
        else{
            throw new Error("liftingCapacity must be more than 0 or equals 0.");
        }
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        if(yearOfProduction >= 0) {
            if(registrationDate == null || yearOfProduction <= registrationDate.getYear()) {
                this.yearOfProduction = yearOfProduction;
            }
            else{
                throw new Error("yearOfProduction must be less than registrationYear.");
            }
        }
        else{
            throw new Error("yearOfProduction must be more than 0 or equals 0.");
        }
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if(yearOfProduction <= registrationDate.getYear()) {
            this.registrationDate = registrationDate;
        }
        else{
            throw new Error("yearOfProduction must be less than registrationYear.");
        }
    }

}
