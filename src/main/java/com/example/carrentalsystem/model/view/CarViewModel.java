package com.example.carrentalsystem.model.view;

public class CarViewModel {

    private Integer id;
    private String brand;
    private String model;
    private int horsePower;
    private int yearCreated;
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public CarViewModel setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public CarViewModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarViewModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarViewModel setModel(String model) {
        this.model = model;
        return this;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public CarViewModel setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public CarViewModel setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
        return this;
    }

    @Override
    public String toString() {
        return "CarViewModel{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", yearCreated=" + yearCreated +
                ", available=" + available +
                '}';
    }
}
