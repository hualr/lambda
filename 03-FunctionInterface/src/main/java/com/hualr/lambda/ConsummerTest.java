package com.hualr.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsummerTest {
    public static void main(String[] args) {
        Consumer<Apple> consumer=(Apple a)->{
            System.out.println("I have a"+a);
        };
        Apple apple=new Apple("red",12);
        new ConsummerUse<Apple>().test(apple,consumer);

        new ConsummerUse<Apple>().test(apple,XXX -> System.out.println(XXX));

        ConsummerUse.forEach(Arrays.asList(1,2,3,4,5),(a)-> System.out.println(a));
    }
}


class ConsummerUse<T>{
    void test(T t,Consumer<T> consumer){
        consumer.accept(t);
        System.out.println("一个消费者");
    }

    static <T> void  forEach(List<T> list,Consumer<T> consumer){
        for (T t:list){
            consumer.accept(t);
        }
    }
}


