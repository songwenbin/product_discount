package com.example.demo;

public class TwentyPercentOffForElectronicsStrategy implements ProductDiscountStrategy {
    @Override
    public double discount(ProductAmountCollection products) {
        double electionicsTotal = CalculaterProductAmount.calculate(products.getElectonicsProductList());
        return DiscountTotalOff.totalDiscount(electionicsTotal, 0.2);
    }
}
