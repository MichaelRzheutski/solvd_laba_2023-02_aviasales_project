package com.solvd.aviasales.util.functional_interfaces;

@FunctionalInterface
public interface IPrintAsMenu<T, V> {
    void print(T index, V line);
}