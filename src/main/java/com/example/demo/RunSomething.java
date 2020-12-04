package com.example.demo;

@FunctionalInterface
public interface RunSomething {

    int doIt(int number);

    static void printName(){
        System.out.println("junseong");
    }

    default void printAge(){
        System.out.println("27");
    }
}
