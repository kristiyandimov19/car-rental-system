package com.example.carrentalsystem.repository;

import com.example.carrentalsystem.model.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
}
