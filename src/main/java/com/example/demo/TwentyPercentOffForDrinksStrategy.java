package com.example.demo;

public class TwentyPercentOffForDrinksStrategy implements ProductDiscountStrategy{

    @Override
    public double discount(ProductAmountCollection products) {
        double drinkTotal = CalculaterProductAmount.calculate(products.getDrinkProductList());
        return DiscountTotalOff.totalDiscount(drinkTotal, 0.2);
    }
}
