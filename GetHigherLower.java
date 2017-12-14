package com.comp20010;

public class GetHigherLower {

    public static long getHigher(long a, int m, int base) {

        return a / Power.power(base, m);
    }

    /*Q2 a) Long version of getLower method*/
    public static long getLower(long a, int m, int base) {
        return a % Power.power(base, m);
    }
}
