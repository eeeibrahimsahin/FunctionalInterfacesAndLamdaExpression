package com.ibra.playground.functionalinterface.lamp;

public class SwitchApplication {

    private static <T> void doSomethingWithLamp(T t, Switcher<T> switcher) {
        t = switcher.switchLamp(t);
    }

    public static void main(String[] args) {

        Switcher<Lamp> switcher = (b) -> {
            b.toggle();
            return b;
        };

        Switcher<Lamp> switcher2 = (b) -> {
            return b;
        };

        Switcher<Lamp> switcher3 = (Lamp l) -> {
            Lamp lamp = new Lamp();
            lamp.toggle();
            return lamp;
        };
        Lamp lamp = new Lamp();
        System.out.println(lamp.toString());
        doSomethingWithLamp(lamp, switcher2);
        System.out.println(lamp.toString());
        doSomethingWithLamp(lamp, switcher);
        System.out.println(lamp.toString());
    }


}
