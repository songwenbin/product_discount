package com.example.demo;

public class TwentyPercentOffForProductsStrategy implements ProductDiscountStrategy{

    @Override
    public double discount(ProductAmountCollection products) {
        double total =  CalculaterProductAmount.calculate(products.getAllProductList());
        return DiscountTotalOff.totalDiscount(total, 0.2);
    }
}
