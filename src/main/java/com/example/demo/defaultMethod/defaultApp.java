package com.example.demo.defaultMethod;

import java.util.*;
import java.util.stream.Collectors;

public class defaultApp {
    public static void main(String[] args) {
        List<String> name= new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        name.forEach(System.out::println);


        Spliterator<String> spliterator=name.spliterator();
        Spliterator<String> spliterator1=spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("==============");
        while(spliterator1.tryAdvance(System.out::println));

        System.out.println("======================");

        Set<String> k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toSet());

        System.out.println("k = " + k);

       // name.removeIf(s -> s.startsWith("k"));
       // name.forEach(System.out::println);


        Comparator<String> compareToIgnoreCase=String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
    }
}
