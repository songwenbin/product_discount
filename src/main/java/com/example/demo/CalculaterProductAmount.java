package com.example.demo;

import java.util.stream.Stream;

public class CalculaterProductAmount {
    public static double calculate(Stream<ProductAmount> products) {
        return products.mapToDouble(t -> t.getProduct().getPrice() * t.getNum()).sum();
    }
}
