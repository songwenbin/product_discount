package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class ProductOrder {
    private Double total = 0.0;

    private List<ProductDiscountStrategy> productDiscountStrategys;
    private ProductAmountCollection productAmountCollection;

    public ProductOrder() {
        productDiscountStrategys = new ArrayList<ProductDiscountStrategy>();
    }

    public ProductOrder addStrategy(ProductDiscountStrategy productDiscountStrategy) {
        productDiscountStrategys.add(productDiscountStrategy);
        return this;
    }

    public void addProducts(List<ProductAmount> productAmounts) {
        productAmountCollection = new ProductAmountCollection(productAmounts);
        this.total = CalculaterProductAmount.calculate(productAmountCollection.getAllProductList());
    }

    public double discount() {
        double reduce = 0.0;
        for (ProductDiscountStrategy strategy : productDiscountStrategys) {
            reduce += strategy.discount(productAmountCollection);
        }
        return reduce;
    }

    public double getTotal() {
        return this.total - this.discount();
    }
}
