package com.comp20010;

import java.math.BigInteger;

public class MultiplyFastBig {

    public static BigInteger multiplyBig(BigInteger a, BigInteger b) {
        int n = Math.max(a.bitLength(), b.bitLength());

        if (a.equals(0) || b.equals(0)) {
            return BigInteger.valueOf(0);
        } else if (n <=2000) {
            return a.multiply(b);
        }

        int m = (n / 2) + (n % 2);
        BigInteger p = a.shiftRight(m);
        BigInteger q = a.subtract(p.shiftLeft(m));
        BigInteger r = b.shiftRight(m);
        BigInteger s = b.subtract(r.shiftLeft(m));

        BigInteger u = multiplyBig(p, r);
        BigInteger w = multiplyBig(q, s);
        BigInteger v = multiplyBig(q.add(p), s.add(r));

        return w.add(v.subtract(w).subtract(u).shiftLeft(m)).add(u.shiftLeft(2*m));
    }
}
