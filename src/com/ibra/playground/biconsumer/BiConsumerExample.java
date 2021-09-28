package com.ibra.playground.biconsumer;

import com.ibra.playground.functionalinterface.lamp.Lamp;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    BiConsumer biConsumer;

    private static <T, U> void doSomethingWithBiConsumer(T t, U u, BiConsumer<T, U> biConsumer) {
        biConsumer.accept(t, u);
    }

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer1 = (a, b) -> System.out.println(a.concat(b));
        doSomethingWithBiConsumer("Hello ", "ibrahim", biConsumer1);

        BiConsumer<Integer, Integer> biConsumer2 = (a, b) -> System.out.println("a+b = " + (a + b));
        doSomethingWithBiConsumer(3,5,biConsumer2);

        BiConsumer<String, Lamp> biConsumer3 = ((s, lamp) -> {
            System.out.println("s = " + s);
            System.out.println("lamp.toString() = " + lamp.toString());
            lamp.toggle();
            System.out.println("lamp.toString() = " + lamp.toString());
        });
        doSomethingWithBiConsumer("Hello ",new Lamp(),biConsumer3);
    }
}
