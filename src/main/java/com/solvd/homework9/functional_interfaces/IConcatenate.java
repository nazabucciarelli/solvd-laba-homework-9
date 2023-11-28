package com.solvd.homework9.functional_interfaces;

@FunctionalInterface
public interface IConcatenate<T> {
    String concatenate(T firstElement, T secondElement, T thirdElement);
}
