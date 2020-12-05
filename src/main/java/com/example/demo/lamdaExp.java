package com.example.demo;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class lamdaExp {
    public static void main(String[] args) {
        lamdaExp lamdaExp=new lamdaExp();
        lamdaExp.run();
    }

    private void run() {
        final int baseNum=10;

        class LocalClass{
            void printBaseNumber(){
                System.out.println(baseNum);
            }
        }  //로컬클래스

        Consumer<Integer> integerConsumer=new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNum);
            }
        }; //익명클래스


        IntConsumer printInt = (i) -> {
            System.out.println(i+baseNum);
        }; //람다  IntConsumer == Consumer<Integer>

        printInt.accept(10);
    }
}
