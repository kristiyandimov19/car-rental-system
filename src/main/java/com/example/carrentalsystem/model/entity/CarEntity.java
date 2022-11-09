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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @Column()
    private boolean available = true;
}
