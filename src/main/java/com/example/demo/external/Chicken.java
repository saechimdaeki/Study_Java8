package com.example.demo.external;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER) //파라미터에 붙일 수 있음.
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)//애노테이션 중복가능.
public @interface Chicken {

    String value();
}
