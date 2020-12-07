package com.example.demo;

public class DefaultBoo implements Boo,Bar{

    String name;

    public DefaultBoo(String name) {
        this.name = name;
    }

    @Override   //충돌하는 DEFAULT 메소드가 있는경우 직접 오바라이딩 해야함.
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }

    @Override
    public void printName() {
        System.out.println(getName());
    }

    @Override
    public String getName() {
        return this.name;
    }

}
