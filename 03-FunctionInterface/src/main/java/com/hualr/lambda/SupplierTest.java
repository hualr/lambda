package com.hualr.lambda;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(new SuppleUse().test(apple,()->1));
    }
}
class SuppleUse{
    Apple test(Apple apple,Supplier<Integer> supply){
        apple.setWeight(supply.get());
        return apple;
    }
}

