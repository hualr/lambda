package com.hualr.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        //Function<Apple,Integer> function= (a)->1;

        Apple apple=new Apple("green",32);
        //一般lambda无法识别类型大概率是因为泛型没有赋值
        System.out.println(new FunctionUse<Apple,Integer>().test(apple,(apple1)->{
            System.out.println("this is a functionTest");
            return apple1.getWeight();
        }));;

        List<Integer> list=FunctionUse.map(Arrays.asList("Java","8","in","action"),s -> s.length());
        System.out.println(list);
    }
}

class FunctionUse<T,R>{
    R test(T t,Function<T,R> function){
        return function.apply(t);
    }

    static <T,R>List<R> map(List<T> list,Function<T,R> function){
        List<R> result=new ArrayList<>();
        for (T t:list){
            result.add(function.apply(t));
        }
        return result;
    }
}
