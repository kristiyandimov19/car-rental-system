package com.example.carrentalsystem.service.impl;

import com.example.carrentalsystem.model.entity.CarEntity;
import com.example.carrentalsystem.model.service.CarServiceModel;
import com.example.carrentalsystem.model.view.CarAvailabilityModel;
import com.example.carrentalsystem.model.view.CarViewModel;
import com.example.carrentalsystem.repository.CarRepository;
import com.example.carrentalsystem.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCars() {

        CarEntity carEntity = new CarEntity()
                .setBrand("Mercedes")
                .setModel("Benz")
                .setHorsePower(300)
                .setYearCreated(2017);
        CarEntity carEntity2 = new CarEntity()
                .setBrand("BMW")
                .setModel("X5 xDrive")
                .setHorsePower(320)
                .setYearCreated(2015);

        carRepository.saveAll(List.of(carEntity, carEntity2));
    }

    @Override
    public void createCar(CarServiceModel carServiceModel) {
        CarEntity carEntity = modelMapper.map(carServiceModel, CarEntity.class);

        carRepository.save(carEntity);
    }

    @Override
    public void changeAvailability(Integer id) {
        CarEntity car = carRepository.findById(id).orElse(null);

        car.setAvailable(false);

        carRepository.save(car);
    }

    @Override
    public List<CarViewModel> findAll() {
        return carRepository.findAll()
                .stream()
                .map(c -> {
                    CarViewModel carViewModel = modelMapper.map(c, CarViewModel.class);
                    return carViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void editCar(Integer id, CarViewModel carViewModel) {
        CarEntity car = carRepository.findById(id).orElse(null);

        car.setBrand(carViewModel.getBrand());
        car.setModel(carViewModel.getModel());
        car.setHorsePower(carViewModel.getHorsePower());
        car.setYearCreated(carViewModel.getYearCreated());

        carRepository.save(car);
    }

    @Override
    public CarAvailabilityModel findById(Integer id) {
        return modelMapper.map(carRepository.findById(id).orElse(null), CarAvailabilityModel.class);
    }
}
