package com.comp20010;

import static java.lang.Integer.max;

public class MultiplyLong {

    public static long multiply(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        } else if (a < 10 || b < 10) {
            return a * b;
        }

        int n = max(Long.toBinaryString(a).length(), Long.toBinaryString(b).length());
        int m = n / 2;
        long p = GetHigherLower.getHigher(a, m, 2);
        long q = GetHigherLower.getLower(a, m, 2);
        long r = GetHigherLower.getHigher(b, m, 2);
        long s = GetHigherLower.getLower(b, m, 2);


        return (p * r) * Power.power(2, 2 * m) + (p * s + q * r) * Power.power(2, m) + q * s;
    }
}
