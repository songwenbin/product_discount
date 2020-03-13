package com.example.demo;

public class OverAndOffForProductsStrategy implements ProductDiscountStrategy {
    @Override
    public double discount(ProductAmountCollection products) {
        double total =  CalculaterProductAmount.calculate(products.getAllProductList());
        return DiscountTotalReduce.reduce(total, 100.0, 15.0, 50.0, 5.0);
    }
}
