package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductDiscountApplicationTests {

    Product wine;
    Product cola;
    Product pork;
    Product chicken;
    Product light;
    List<ProductAmount> productAmountList;

    @BeforeEach
    void contextLoads() {
        wine = new DrinkProduct("wine", 15.0);
        cola = new DrinkProduct("cola", 5.0);
        pork = new MeatProduct("pork", 25.0);
        chicken = new MeatProduct("chicken", 10.0);
        light = new ElectonicsProduct("light", 100.0);
        productAmountList = Arrays.asList(new ProductAmount(wine, 1),
                new ProductAmount(cola, 2),
                new ProductAmount(pork, 2),
                new ProductAmount(chicken, 5),
                new ProductAmount(light, 1));

    }

    //@ParameterizedTest
    @Test
    void 所有产品正常价格() {
        ProductOrder order = new ProductOrder();
        order.addProducts(productAmountList);
        assertEquals(225.0, order.getTotal(), 0.1);
    }

    @Test
    void 所有产品8折() {
        ProductOrder order = new ProductOrder();
        order.addStrategy(new TwentyPercentOffForProductsStrategy());
        order.addProducts(productAmountList);
        assertEquals(180.0, order.getTotal(), 0.1);
    }

    @Test
    void 满50减5元满100减50_15元封顶() {
        ProductOrder order = new ProductOrder();
        order.addStrategy(new OverAndOffForProductsStrategy());
        order.addProducts(productAmountList);
        assertEquals(210, order.getTotal(), 0.1);
    }

    @Test
    void 饮料8折优惠() {
        ProductOrder order = new ProductOrder();
        order.addStrategy(new TwentyPercentOffForDrinksStrategy());
        order.addProducts(productAmountList);
        assertEquals(220, order.getTotal(), 0.1);
    }

    @Test
    void 饮料8折优惠_肉类满20减2元满60减8元_8元封顶() {
        ProductOrder order = new ProductOrder();
        order.addStrategy(new TwentyPercentOffForDrinksStrategy()).addStrategy(new OverAndOffForMeatStrategy());
        order.addProducts(productAmountList);
        assertEquals(212, order.getTotal(), 0.1);
    }

    @Test
    void 饮料8折优惠_肉类满20减2元满60减8元_8元封顶_猪肉不打折() {
        ProductOrder order = new ProductOrder();
        order.addStrategy(new TwentyPercentOffForDrinksStrategy()).addStrategy(new OverAndOffForMeatWithoutPorkStrategy());
        order.addProducts(productAmountList);
        assertEquals(218, order.getTotal(), 0.1);
    }

    @Test
    void 同类饮料第二杯半价_肉类满20减2元满60减8元_8元封顶_猪肉不打折() {
        ProductOrder order = new ProductOrder();
        order.addStrategy(new FiftyPercentForSecondCupStrategy()).addStrategy(new OverAndOffForMeatWithoutPorkStrategy());
        order.addProducts(productAmountList);
        assertEquals(220.5, order.getTotal(), 0.1);
    }

    @Test
    void 同类饮料第二杯半价_肉类满20减2元满60减8元_8元封顶_猪肉不打折_电器类8折优惠() {
        ProductOrder order = new ProductOrder();
        order.addStrategy(new FiftyPercentForSecondCupStrategy()).addStrategy(new OverAndOffForMeatWithoutPorkStrategy()).addStrategy(new TwentyPercentOffForElectronicsStrategy());
        order.addProducts(productAmountList);
        assertEquals(200.5, order.getTotal(), 0.1);
    }
}
