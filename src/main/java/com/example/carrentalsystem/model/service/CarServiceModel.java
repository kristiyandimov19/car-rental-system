package com.example.carrentalsystem.model.service;

public class CarServiceModel {

    private String brand;
    private String model;
    private int horsePower;
    private int yearCreated;


    public String getBrand() {
        return brand;
    }

    public CarServiceModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarServiceModel setModel(String model) {
        this.model = model;
        return this;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public CarServiceModel setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public CarServiceModel setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
        return this;
    }

    @Override
    public String toString() {
        return "CarServiceModel{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", yearCreated=" + yearCreated +
                '}';
    }
}
