package com.example.demo.external;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘간장") //repetable해서 annotation중복가능
public class externalApp {
//    public static void main(@Chicken String[] args) throws @Chicken RuntimeException{
//        List<@Chicken String> names= Arrays.asList("junseong");
//    }
//
//    static class FeelsLikeChicken<@Chicken T>{
//
//        public static <@Chicken C> void  print(@Chicken C c){
//            System.out.println(c);
//        }
//    }

    public static void main(String[] args) {
//        Chicken[] chickens=externalApp.class.getAnnotationsByType(Chicken.class);
//        Arrays.stream(chickens).forEach(c -> {
//            System.out.println(c.value());
//        });

        ChickenContainer annotation = externalApp.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(annotation.value()).forEach(c->{
            System.out.println(c.value());
        });
    }
}
