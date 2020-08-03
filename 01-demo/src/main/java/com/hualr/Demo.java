package com.hualr;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Demo {
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> greenApples= new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())){
                greenApples.add(apple);
            }
        }
        return greenApples;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory,String color){
        List<Apple> colorApples= new ArrayList<>();
        for (Apple apple: inventory){
            if (color.equals(apple.getColor())){
                colorApples.add(apple);
            }
        }
        return colorApples;
    }

    public static List<Apple> filterApplesByCondition(List<Apple> inventory,ApplePredicate applePredicate){
        List<Apple> conditionApples= new ArrayList<>();
        for (Apple apple: inventory){
            if (applePredicate.test(apple)){
                conditionApples.add(apple);
            }
        }
        return conditionApples;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate ){
        List<T> result=new ArrayList<>();
        for (T e:list){
            if (predicate.test(e)){
                result.add(e);
            }
        }
        return result;
    }


}
