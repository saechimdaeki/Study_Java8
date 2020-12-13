package com.example.demo.conCurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrentApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()); //메인쓰레드

        MyThread myThread=new MyThread();
        myThread.start();

        System.out.println("1Hello ");//코드상으로는 THREAD가먼저인데 HELLO가먼저출력됨.

        //두번째방법
        Thread thread=new Thread(() -> {
            try{
                Thread.sleep(3000L);
            }catch(InterruptedException e){
                throw new IllegalStateException(e);
            }
            System.out.println("Thread: "+ Thread.currentThread().getName());
        });
        thread.start();

        System.out.println("2Hello: "+Thread.currentThread().getName());
        //Thread.sleep(3000L);
        //thread.interrupt();
        thread.join(); //기다렸다가 그다음라인이 실행됨.
        System.out.println(thread+ " is finished");

        //=================Executors===================
        System.out.println("=================Executors===================");
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.submit(() ->
                System.out.println("Thread "+Thread.currentThread().getName()));
        //executorService.shutdown();


        ExecutorService executorService1=Executors.newFixedThreadPool(2);
        executorService1.submit(getRunnable("Hello"));
        executorService1.submit(getRunnable("Junseong"));
        executorService1.submit(getRunnable("The"));
        executorService1.submit(getRunnable("Java"));
        executorService1.submit(getRunnable("Thread"));


        ScheduledExecutorService executorService2=Executors.newSingleThreadScheduledExecutor();
        executorService2.scheduleAtFixedRate(getRunnable("Hello"),1,2, TimeUnit.DAYS);


       /// executorService1.shutdown();

    }
    private static Runnable getRunnable(String message){
        return () -> System.out.println(message+ Thread.currentThread().getName());
    }

    static class MyThread extends Thread{ //1번째 방법

        @Override
        public void run() {
            System.out.println("Thread: "+ Thread.currentThread().getName());
        }
    }


}
