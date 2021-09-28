package com.ibra.playground.functionalinterface.lamp;

@FunctionalInterface
public interface Switcher<T> {
    T switchLamp(T t);
}
