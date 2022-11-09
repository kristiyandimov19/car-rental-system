package com.example.carrentalsystem.service;

import com.example.carrentalsystem.model.entity.CarEntity;
import com.example.carrentalsystem.model.service.CarServiceModel;
import com.example.carrentalsystem.model.view.CarViewModel;

import java.util.List;

public interface CarService {

    void seedCars();

    void createCar(CarServiceModel carServiceModel);

    CarViewModel findById(Integer id);

    List<CarViewModel> findAll();

    void editCar(Integer id, CarViewModel carViewModel);

}
