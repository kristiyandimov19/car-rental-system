package com.example.carrentalsystem.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "car")
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity extends BaseEntity {

    @Column(name = "brand", nullable = false)
    @NotBlank
    @Length(min = 3, max = 20)
    private String brand;
    @Column(name = "model", nullable = false, unique = true)
    @NotBlank
    @Length(min = 3, max = 20)
    private String model;
    @Column(name = "horse_power")
    @Min(1)
    private int horsePower;
    @Column(name = "year_created")
    @Min(1800)
    private int yearCreated;
    @Column(name = "available", columnDefinition = "boolean default true")
    private boolean available = true;

    public String getBrand() {
        return brand;
    }

    public CarEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public CarEntity setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public CarEntity setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public CarEntity setAvailable(boolean available) {
        this.available = available;
        return this;
    }
}
