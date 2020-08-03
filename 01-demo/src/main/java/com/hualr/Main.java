package com.hualr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Apple apple1=new Apple("green",15);
        Apple apple2=new Apple("red",23);
        Apple apple3=new Apple("green",15);
        Apple apple4=new Apple("green",7);
        Apple apple5=new Apple("green",13);
        Apple apple6=new Apple("red",27);

        List<Apple> apples= Arrays.asList(apple1,apple2,apple3,apple4,apple5,apple6);

        //单纯指定一个条件
        List<Apple> greenApples=Demo.filterGreenApples(apples);
        System.out.println(greenApples);

        //根据颜色筛选
        List<Apple> redApples=Demo.filterApplesByColor(apples,"red");
        System.out.println(redApples);

        /**根据指定的条件筛选
         * 直接将接口作为参数 然后创建一个匿名类 实现该匿名类即可
         */
        List<Apple> conditionApples=Demo.filterApplesByCondition(apples, new ApplePredicate() {

            @Override
            public boolean test(Apple apple) {
                return (apple.getColor().equals("red"))&& (apple.getWeight()>25);
            }
        });
        System.out.println(conditionApples);

        //直接替换为lambda表达式.这里我清楚的是,传入的参数是根据方法声明判断的
        List<Apple> conditionApples2=Demo.filterApplesByCondition (apples,
                (apple)->(apple.getColor().equals("red")&&apple.getWeight()>26));

        System.out.println(conditionApples2);

        List<Apple> condictionApples3=Demo.filter(apples, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight()>10;
            }
        });

        System.out.println(condictionApples3);

        List<Apple> condictionApples4=Demo.filter(apples,(apple -> apple.getWeight()>10));
        System.out.println(condictionApples4);

    }
}
