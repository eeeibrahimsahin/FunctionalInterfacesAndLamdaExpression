package com.ibra.playground.consumer;

import com.ibra.playground.functionalinterface.lamp.Lamp;

import java.util.function.Consumer;

public class ConsumerExample {
    Consumer<String> consumer;

    private static <T> void doSomethingWithConsumer(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    public static void main(String[] args) {
        Consumer<String> consumer = a -> System.out.println("a = " + a);
        doSomethingWithConsumer("Hello", consumer);
        Consumer<Lamp> lampConsumer = lamp -> {
            System.out.println(lamp.toString());
            lamp.toggle();
            System.out.println(lamp.toString());
        };
        doSomethingWithConsumer(new Lamp(),lampConsumer);
    }
}
