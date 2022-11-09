package com.example.carrentalsystem.controller;

import com.example.carrentalsystem.model.service.CarServiceModel;
import com.example.carrentalsystem.model.view.CarViewModel;
import com.example.carrentalsystem.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/car")
@RestController
public class CarController {

    private final CarService carService;
    private final ModelMapper modelMapper;

    public CarController(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public String create(@RequestBody @Valid CarViewModel carViewModel) {

        CarServiceModel carServiceModel = modelMapper.map(carViewModel, CarServiceModel.class);

        carService.createCar(carServiceModel);

        return carServiceModel.toString();
    }

    @GetMapping("/all")
    public List<CarViewModel> getAllCars() {
        return carService.findAll();
    }

    @PutMapping("{id}")
    public String edit(@RequestBody @Valid CarViewModel carViewModel,
                       @PathVariable Integer id) {

        carService.editCar(id, carViewModel);

        return carViewModel.toString();
    }

}
