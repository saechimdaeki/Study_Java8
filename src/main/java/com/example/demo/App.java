package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        //Function<Integer,String> intToString =(i)->"number";

        Greeting greeting=new Greeting();
        UnaryOperator<String> hi=(s) ->"hi"+s;

        UnaryOperator<String> hi2=Greeting::hi; // 스태틱 메소드 참조
        UnaryOperator<String> hello=greeting::hello; //특정 객체의 인스턴스 메소드 참조


        Supplier<Greeting> newGreeting= Greeting::new; //이렇게 하면 만들어지는게아닌
        Greeting greeting1 = newGreeting.get(); //아래처럼 get을 해야 만들어진다.


        Function<String,Greeting> junSeongGreeting=Greeting::new;
        Greeting junseong = junSeongGreeting.apply("junseong");
        System.out.println("준성 네임 = "+ junseong.getName());

        Supplier<Greeting> newGreeting2=Greeting::new; //이 두개는 다른 생성자를 참조하고 있음..


        String[] names= {"keesun","whiteship","toby"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
