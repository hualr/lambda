package com.hualr.lambda.future;

import java.util.concurrent.*;

public class CommonFuture {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newCachedThreadPool();
        Future<Double> future=executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                System.out.println("我在进行异步操作");
                return 1.0;
            }
        });
        //异步提交了 但是我们这里会优先执行一个1;
        //且我们发现这是一个死循环 永远到不到get
        for(int i=0;i<=100000000;i++){
            if (i==1){
                System.out.println(1);
            }
         /*   if (i==100000000){
                i=-100000000;
            }*/

        }
        System.out.println("完成计算");
        try{
            Double result= future.get(1, TimeUnit.SECONDS);
            System.out.println("result:"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("完成异步调用");
    }
}
