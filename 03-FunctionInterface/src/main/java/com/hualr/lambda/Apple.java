package com.hualr.lambda;

import lombok.Data;

@Data
public class Apple {
    private String color;
    private Integer weight;

    public Apple() {
    }

    public Apple(String color) {
        this.color = color;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }
}
