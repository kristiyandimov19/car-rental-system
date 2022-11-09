package com.example.carrentalsystem.service.impl;

import com.example.carrentalsystem.model.entity.CarEntity;
import com.example.carrentalsystem.model.service.CarServiceModel;
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

        CarEntity carEntity = CarEntity.builder()
                .brand("Mercedes")
                .model("Benz")
                .horsePower(300)
                .yearCreated(2017)
                .build();

        CarEntity carEntity2 = CarEntity.builder()
                .brand("BMW")
                .model("X5 xDrive")
                .horsePower(320)
                .yearCreated(2015)
                .build();

        carRepository.saveAll(List.of(carEntity, carEntity2));
    }

    @Override
    public void createCar(CarServiceModel carServiceModel) {
        CarEntity carEntity = modelMapper.map(carServiceModel, CarEntity.class);

        carRepository.save(carEntity);
    }

    @Override
    public CarViewModel findById(Integer id) {
        return modelMapper.map(carRepository.findById(id), CarViewModel.class);
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
}
