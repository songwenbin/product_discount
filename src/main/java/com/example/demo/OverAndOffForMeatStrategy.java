package com.example.demo;

public class OverAndOffForMeatStrategy implements ProductDiscountStrategy {

    @Override
    public double discount(ProductAmountCollection products) {
        double meatTotal = CalculaterProductAmount.calculate(products.getMeatProductList());
        return DiscountTotalReduce.reduce(meatTotal, 60.0, 8.0, 20.0, 2.0);
    }

}
