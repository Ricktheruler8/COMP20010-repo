package com.comp20010;

import java.math.BigInteger;

public class MultiplyLongBig {

    public static BigInteger multiplyBig(BigInteger a, BigInteger b) {
        if (a.equals(0) || b.equals(0)) {
            return BigInteger.valueOf(0);
        } else if (a.compareTo(BigInteger.valueOf(10)) < 0 || b.compareTo(BigInteger.valueOf(10)) < 0) {
            return a.multiply(b);
        }

        int n = Math.max(a.bitLength(), b.bitLength());
        int m = n / 2;
        BigInteger p = GetHigherLowerBig.getHigherBig(a, m, 2);
        BigInteger q = GetHigherLowerBig.getLowerBig(a, m, 2);
        BigInteger r = GetHigherLowerBig.getHigherBig(b, m, 2);
        BigInteger s = GetHigherLowerBig.getLowerBig(b, m, 2);


        return ((p.multiply(r)).multiply(BigInteger.valueOf(2).pow(2 * m))).add((p.multiply(s).add(q.multiply(r))).multiply(BigInteger.valueOf(2).pow(m)).add(q.multiply(s)));
    }
}
