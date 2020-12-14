package com.example.demo.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class completableFutureApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(4);
//        Future<String> future = executorService.submit(() -> "hello");
//        //TODO
//        future.get(); //블럭킹 콜


//        CompletableFuture<String> future=CompletableFuture.completedFuture("junseong");
//        System.out.println(future.get());

//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("junseong" + Thread.currentThread().getName());
//        }); //리턴없는 경우
//        future.get();

//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("junseong" + Thread.currentThread().getName());
//            return "hello";
//        });
//        System.out.println(future.get());


//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("junseong" + Thread.currentThread().getName());
//            return "hello";
//        }).thenAccept((s)->{
//            System.out.println(Thread.currentThread().getName());
//        });
//        future.get();

        System.out.println("==================CompletableFuture2================");

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World" + Thread.currentThread().getName());
            return "World";
        });
        //CompletableFuture<String> future = hello.thenCompose(completableFutureApp::getWorld);
        //System.out.println(future.get());

//        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
//        System.out.println(future.get());

//        CompletableFuture<Void> future = CompletableFuture.allOf(hello, world)
//                .thenAccept(System.out::println);
//        System.out.println(future.get()); //null 이나옴

//        List<CompletableFuture<String>> futures= Arrays.asList(hello,world);
//        CompletableFuture[] futuresArray=futures.toArray(new CompletableFuture[futures.size()]);
//        CompletableFuture<List<Object>> results = CompletableFuture.allOf(futuresArray)
//                .thenApply(v -> futures.stream()
//                        .map(CompletableFuture::join)
//                        .collect(Collectors.toList()));
//        results.get().forEach(System.out::println);

        CompletableFuture<Void> future = CompletableFuture.anyOf(hello, world)
                .thenAccept(System.out::println);
        future.get(); // any of 를 사용했기에 먼저오는 것 출력
    }

//    private static CompletableFuture<String> getWorld(String message) {
//       return CompletableFuture.supplyAsync(() -> {
//            System.out.println("World" + Thread.currentThread().getName());
//            return message+"World";
//        });
//    }
}
