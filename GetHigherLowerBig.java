package com.comp20010;

import java.math.BigInteger;

public class GetHigherLowerBig {

    public static BigInteger getHigherBig(BigInteger a, int m, long base) {
        return a.divide(BigInteger.valueOf(base).pow(m));
    }

    /*Q3 d) BigInteger version of getLower*/
    public static BigInteger getLowerBig(BigInteger a, int m, long base) {
        return a.mod(BigInteger.valueOf(base).pow(m));
    }
}
