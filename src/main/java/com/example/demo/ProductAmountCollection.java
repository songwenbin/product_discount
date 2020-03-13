package com.example.demo;

import java.util.List;
import java.util.stream.Stream;

public class ProductAmountCollection {
    List<ProductAmount> productAmounts;

    public ProductAmountCollection(List<ProductAmount> productAmounts) {
        this.productAmounts = productAmounts;
    }

    public Stream<ProductAmount> getAllProductList() {
        return productAmounts.stream();
    }

    public Stream<ProductAmount> getDrinkProductList() {
        return productAmounts.stream().filter(t -> t.getProduct() instanceof DrinkProduct);
    }

    public Stream<ProductAmount> getElectonicsProductList() {
        return productAmounts.stream().filter(t -> t.getProduct() instanceof ElectonicsProduct);
    }

    public Stream<ProductAmount> getMeatProductList() {
        return productAmounts.stream().filter(t -> t.getProduct() instanceof MeatProduct);
    }
}
