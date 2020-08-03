package com.hualr.lambda;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Apple{
    private String color;
    private Integer weight;


    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }


}
