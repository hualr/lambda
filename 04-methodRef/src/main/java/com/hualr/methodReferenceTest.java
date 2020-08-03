package com.hualr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class methodReferenceTest {
    public static void main(String[] args) {
        Apple apple1=new Apple("green",15);
        Apple apple2=new Apple("red",23);
        Apple apple3=new Apple("green",15);
        Apple apple4=new Apple("green",7);
        Apple apple5=new Apple("green",13);
        Apple apple6=new Apple("red",27);

        List<Apple> apples= Arrays.asList(apple1,apple2,apple3,apple4,apple5);


        apples.sort(Comparator.comparing(apple -> apple.getWeight()));
        System.out.println(apples);
        apples.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(apples);

        //1. 静态方法引用
        System.out.println(Integer.parseInt("100"));
        System.out.println(new MethodUse1().test1("50",s -> Integer.parseInt(s)));
        //方法引用一定是根据lambda可以改编的
        System.out.println(new MethodUse1().test1("30",Integer::parseInt));
        //要想让lambda认识s是String 得写入<>指定类型
        System.out.println(new MethodUse2<String,Integer>().test2("20",s->Integer.parseInt(s)));
        System.out.println(new MethodUse2<String,Integer>().test2("15",Integer::parseInt));


        //2. 对象的普通引用
        System.out.println(new MethodUse2<String,Integer>().test2("14111",s -> s.length()));
        System.out.println(new MethodUse2<String,Integer>().test2("15",String::length));

        List<String> str = Arrays.asList("a","b","A","B");
        str.sort(String::compareTo);
        //如何转化为lambda

        //构造函数  我感觉好鸡肋啊
        // Supplier<Apple> c1=()->new Apple();
        Supplier<Apple> c1=Apple::new;
        Apple apple7=c1.get();

        //Function<Integer,Apple> c2=(weight)-> new Apple(weight);
        Function<Integer,Apple> c2=Apple::new;
        Apple apple8=c2.apply(100);

        //BiFunction<String,Integer,Apple> c3=(color,weight)->new Apple(color,weight);
        BiFunction<String,Integer,Apple> c3=Apple::new;
        Apple apple9=c3.apply("red",7);


    }
}

class MethodUse1{
    Integer test1(String s,Function<String,Integer> function){
        return function.apply(s);
    }
}

class MethodUse2<R,T>{

    Integer test1(String s,Function<String,Integer> function){
        return function.apply(s);
    }
    T test2(R r, Function<R,T> function){
        return function.apply(r);
    }
}
