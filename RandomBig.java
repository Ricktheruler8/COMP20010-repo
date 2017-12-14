package com.comp20010;

import java.math.BigInteger;
import java.util.Random;

public class RandomBig {

    public static BigInteger randomBigInteger(int nDigits, Random rnd) {
        BigInteger r = new BigInteger(nDigits, rnd);

        while (r.bitLength() != nDigits) {
            r = new BigInteger(nDigits, rnd);
        }
        return r;
    }
}
