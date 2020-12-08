package com.example.demo.defaultMethod;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class defaultApp {
    public static void main(String[] args) {
        List<String> names= new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        names.forEach(System.out::println);


        Spliterator<String> spliterator=names.spliterator();
        Spliterator<String> spliterator1=spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("==============");
        while(spliterator1.tryAdvance(System.out::println));

        System.out.println("======================");

        Set<String> k = names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toSet());

        System.out.println("k = " + k);

       // name.removeIf(s -> s.startsWith("k"));
       // name.forEach(System.out::println);


        Comparator<String> compareToIgnoreCase=String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
        names.forEach(System.out::println);



        ///// 8장 Stream.
        System.out.println("=================8장 Stream================");

        Stream<String> stringStream=names.stream().map(String::toUpperCase);
        stringStream.forEach(System.out::println);

        names.stream().map((s)->{
            System.out.println(s);
            return s.toUpperCase();
        });  // 중개형 오퍼레이터는 출력을 하지 않음..
        //  이 뒤에 .collect(Collectors.toList()); 를붙인다면 종료형 오퍼레이터임.

        List<String> collect=names.parallelStream().map((s) -> {
            System.out.println(s+" "+Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println); //parallelStream을 사용하면 병렬적으로 처리가능

    }
}
