package com.example.demo;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        int baseNum=10;
           RunSomething runSomething1=new RunSomething() {
               @Override
               public int doIt(int number) {
                   return 0;
               }
           };
        RunSomething runSomething2= number -> number+baseNum;
        /*=================자바에서 제공하는 미리정의 된 함수형 인터페이스============================ */
        Plus10 plus10=new Plus10();
        System.out.println("plus10 = " + plus10.apply(1));


        Function<Integer,Integer> plus10_2= (i)-> i+10;
        Function<Integer,Integer> multiply2=(i)-> i*2;
        System.out.println("plus10_2 = "+plus10_2.apply(1));
        System.out.println("multiply2 = " + multiply2.apply(1));

        Function<Integer,Integer> multiply2AndPlus1=plus10_2.compose(multiply2); //입력값을 가지고먼저 뒤에오는함수를 적용 결과값을 plus10에 입력값으로활용
        System.out.println(multiply2AndPlus1.apply(2));
        System.out.println(plus10_2.andThen(multiply2).apply(2)); // 입력값이들어오면 앞에먼저 한다음 뒤에 함수의 입력값으로 쓰게됨.


        Consumer<Integer> printT= (i) -> System.out.println("i = " + i);
        printT.accept(10);


        Supplier<Integer> get10= () -> 10;
        System.out.println("get10 = " + get10);



        Predicate<String> startsWithJunSeong=(s) -> s.startsWith("JunSeong");
        Predicate<Integer> isEven = (i)-> i%2==0;


        UnaryOperator<Integer> plus10_3 = (i) -> i+10; //입력타입과 리턴타입이 같을때. (Function을 상속받음)

    }
}
