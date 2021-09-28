package com.ibra.playground.predicate;

import com.ibra.playground.functionalinterface.lamp.Lamp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    Predicate predicate;

    private static <T> boolean doSomethingWithPredicate(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    public static void main(String[] args) {
        Predicate<Lamp> lampPredicate = lamp -> lamp.isOn();
        boolean test1 = doSomethingWithPredicate(new Lamp(), lampPredicate);
        System.out.println("test1 = " + test1);
        Lamp lamp = new Lamp();
        lamp.toggle();
        boolean test2 = doSomethingWithPredicate(lamp, lampPredicate);
        System.out.println("test2 = " + test2);

        Predicate<String> predicate = s -> s.startsWith("A");
        boolean test3 = doSomethingWithPredicate("Alooo", predicate);
        System.out.println("test3 = " + test3);

        Predicate<Integer> integerPredicate = integer -> integer % 2 == 0;
        boolean test4 = doSomethingWithPredicate(3, integerPredicate);
        System.out.println("test4 = " + test4);
        boolean test5 = doSomethingWithPredicate(4, integerPredicate);
        System.out.println("test5 = " + test5);

        List<Lamp> lamps = new ArrayList<>();
        lamps.add(new Lamp(true));
        lamps.add(new Lamp(false));
        lamps.add(new Lamp(true));
        lamps.add(new Lamp(false));
        lamps.add(new Lamp(true));
        lamps.add(new Lamp(true));

        lamps.stream().filter(lampPredicate).forEach(System.out::println);
    }
}
