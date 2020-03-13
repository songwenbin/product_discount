package com.example.demo;

class ProductAmount {
    private Product product;
    private Integer num;

    public ProductAmount(Product product, int num) {
        this.product = product;
        this.num = num;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
