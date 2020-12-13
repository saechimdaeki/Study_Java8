package com.example.demo.conCurrent;

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
    }

    static class MyThread extends Thread{ //1번째 방법

        @Override
        public void run() {
            System.out.println("Thread: "+ Thread.currentThread().getName());
        }
    }


}
