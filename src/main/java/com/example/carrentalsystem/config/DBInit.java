package com.example.carrentalsystem.config;

import com.example.carrentalsystem.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final CarService carService;

    public DBInit(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void run(String... args) throws Exception {

        carService.seedCars();
    }
}
