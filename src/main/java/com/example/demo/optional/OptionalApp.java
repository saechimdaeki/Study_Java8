package com.example.demo.optional;

import com.example.demo.streamApi.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class OptionalApp {

    public static void main(String[] args) {
        List<OnlineClass> springClasses=new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(2,"spring data jpa",true));
        springClasses.add(new OnlineClass(3,"spring mvc",false));
        springClasses.add(new OnlineClass(4,"spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development",false));

//        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        Duration studyDuration = spring_boot.getProcess().get().getStudyDuration();;
//        System.out.println(studyDuration);  //NullPointException

        OptionalInt.of(10); //Optional.of(10)보다는 이런식하는게 나음.

    }
}
