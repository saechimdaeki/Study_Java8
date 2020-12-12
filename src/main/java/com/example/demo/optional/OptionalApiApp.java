package com.example.demo.optional;

import com.example.demo.streamApi.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApiApp {
    public static void main(String[] args) {
        List<OnlineClass> springClasses=new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(5,"rest api development",false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = spring.isPresent();
        OnlineClass onlineClass = spring.get();
        System.out.println(present);
        System.out.println(onlineClass.getTitle());
        System.out.println("====================================");
        spring.ifPresent(
                oc-> System.out.println(oc.getTitle()) //get으로 꺼내는 코드없이 처리!
        );

        OnlineClass onlineClass1=spring.orElseGet(OptionalApiApp::createNewClasses);  //있는경우에는 Supplier 사용안함. 없는경우 createNewClass 호출

        OnlineClass onlineClass2 = spring.orElseThrow(IllegalArgumentException::new);

        System.out.println(onlineClass1.getTitle());

        Optional<OnlineClass> onlineClass3 = spring.filter(oc -> !oc.isClosed());
        System.out.println(onlineClass3.isEmpty());


        Optional<Integer> integer = spring.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Progress> progress=spring.flatMap(OnlineClass::getProcess);
        Optional<Optional<Progress>> progress1 = spring.map(OnlineClass::getProcess);
        Optional<Progress> progress2 = progress1.orElse(Optional.empty());
        

    }

    private static OnlineClass createNewClasses() {
        System.out.println("creating new online class");
        return new OnlineClass(10,"New Class",false);
    }
}
