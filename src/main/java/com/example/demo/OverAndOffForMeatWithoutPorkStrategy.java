package com.example.demo;

public class OverAndOffForMeatWithoutPorkStrategy implements ProductDiscountStrategy {
    @Override
    public double discount(ProductAmountCollection products) {
        double meatTotalWithoutPork = CalculaterProductAmount.calculate(products.getMeatProductList().filter(productAmount -> !productAmount.getProduct().getName().equals("pork")));
        return DiscountTotalReduce.reduce(meatTotalWithoutPork, 60.0, 8.0, 20.0, 2.0);
    }
}
