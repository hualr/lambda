package com.hualr.lambda.future;

import com.hualr.lambda.bean.Shop;

public class Future1 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println(1);
        new Shop().getPrice("fewfw");
        System.out.println(2);




    }
}
