package com.hualr.bean;

import lombok.Data;

import java.util.Optional;

@Data
public class Car {
    private Insurance insurance;
    private Optional<Insurance> optionalInsurance;
}