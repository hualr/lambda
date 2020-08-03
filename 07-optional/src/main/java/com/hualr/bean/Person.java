package com.hualr.bean;

import lombok.Data;

import java.util.Optional;

@Data
public class Person {
    private Car car;
    private Optional<Car> optionalCar;
}