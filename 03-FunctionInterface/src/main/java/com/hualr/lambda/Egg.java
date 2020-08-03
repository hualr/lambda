package com.hualr.lambda;

import lombok.Data;

@Data
public class Egg {
    private Integer weight;
    private String shape;

    public Egg(Integer weight, String shape) {
        this.weight = weight;
        this.shape = shape;
    }
}
