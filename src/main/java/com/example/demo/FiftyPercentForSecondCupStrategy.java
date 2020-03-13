package com.example.demo;

public class FiftyPercentForSecondCupStrategy implements ProductDiscountStrategy {
    @Override
    public double discount(ProductAmountCollection products) {
        double more2cup = CalculaterProductAmount.calculate(products.getDrinkProductList().filter(productAmount -> productAmount.getNum() >= 2));
        return DiscountTotalOff.totalDiscount(more2cup, 0.25);
    }
}
