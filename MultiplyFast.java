package com.comp20010;

public class MultiplyFast {

    public static long multiply(long a, long b) {
        int n = Math.max(Long.toBinaryString(a).length(), Long.toBinaryString(b).length());

        if (a == 0 || b == 0) {
            return 0;
        } else if (a < 10 || b < 10) {
            return a * b;
        }

        int m = n / 2;
        long p = GetHigherLower.getHigher(a, m, 2);
        long q = GetHigherLower.getLower(a, m, 2);
        long r = GetHigherLower.getHigher(b, m, 2);
        long s = GetHigherLower.getLower(b, m, 2);

        long u = multiply(p, r);
        long w = multiply(q, s);
        long v = multiply((q - p), (s - r));

        return (u * Power.power(2, 2 * m)) + ((u + w - v) * Power.power(2, m)) + w;
    }
}
