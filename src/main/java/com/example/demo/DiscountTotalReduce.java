package com.example.demo;

public class DiscountTotalReduce {
    public static double reduce(double total, double bound1, double reduce1, double bound2, double reduce2) {
        if (total > bound1) {
            return reduce1;
        }
        if (total > bound2) {
            return reduce2;
        }

        return 0.0;
    }
}
