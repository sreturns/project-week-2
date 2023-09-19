package com.projectweek2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectweek2.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
