package com.comp20010;

public class Power {

    public static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return power(a * a, b / 2);
        }
        return power(a * a, b / 2) * a;
    }
}
