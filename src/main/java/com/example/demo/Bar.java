package com.example.demo;

public interface Bar extends Boo {

    default void printNameUpperCase(){
        System.out.println("BAR");
    }


}
