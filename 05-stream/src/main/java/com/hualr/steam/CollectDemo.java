package com.hualr.steam;

import java.util.*;
import java.util.stream.Collectors;

public class CollectDemo {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        //1. 归约和汇总
        //1.1 统计所有值
        long howManyDishes = menu.stream()
                .collect(Collectors.counting());
        //1.2 查找最大值
        Comparator<Dish> dishComparator = Comparator.comparing(Dish::getCalories);
        Optional<Dish> mostcaloriesDish = menu.stream().
                collect(Collectors.maxBy(dishComparator));

        //1.3 汇总:将所有对象求和为int所需的函数
        int totalCalories = menu.stream().
                collect(Collectors.summingInt(o -> o.getCalories()));


        Map<String, Integer> dishMap1 = menu
                .stream()
                .collect(Collectors.toMap(Dish::getName,Dish::getCalories));
        dishMap1.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }
}
