package com.hualr.lambda;

public class RunnableTest {
    public static void main(String[] args) {
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world1");
            }
        };

        Runnable r2=()->{};

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });
        //实际上就是在Thread中放入runnable

        Thread thread2=new Thread(()-> System.out.println("hello world"));
        Thread thread3=new Thread(r2);

        /**
         * 破解lambda的几个关键
         * 1. 找到接口是谁.根据接口中唯一的方法判断参数类型
         * 2. 根据方法返回确认return的是谁
         * 3. 判断到底是谁在用接口的方法 这个方法在哪里被使用
         */

//        我们想要在lambda中使用局部变量,必须保证该变量事实上是一个final
/*        int portNumber=1;
        Runnable runnable3=()->{
            System.out.println(portNumber);
        };
        portNumber=0;
*/

    }
}
