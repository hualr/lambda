package com.hualr.lambda;

public class RunnableDemo {
    public static void main(String[] args) throws InterruptedException {
     // 不太熟悉 这个之后复习多线程的时候再说
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });

        Thread thread2=new Thread(()-> System.out.println("hello world"));
        Thread thread3=new Thread(()->{});
        Thread thread4=new Thread(()->{
            System.out.println("hello world3");
            System.out.println("hello world4");
        });
    }
}
