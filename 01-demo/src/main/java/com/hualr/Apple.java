package com.hualr;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class Apple  {
    private String color;
    private int weight;

    public Apple() {
    }

    public Apple(String color) {
        this.color = color;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }


    public String getColor() {
        return color;
    }



}
