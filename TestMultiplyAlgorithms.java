package com.comp20010;

import java.math.BigInteger;

public class TestMultiplyAlgorithms {

    public static void testAlgorithms() {
        long a = 12345678L;
        long b = 87654321L;
        long res = MultiplyLong.multiply(a, b);
        System.out.println("MultiplyLong method");
        System.out.println(a + " x " + b + " = " + res + "\n" + (a * b == res) + "\n");

        System.out.println("MultiplyFast method");
        long res1 = MultiplyFast.multiply(a, b);
        System.out.println(a + " x " + b + " = " + res1 + "\n" + (a * b == res1) + "\n");

        BigInteger a2 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger res2 = MultiplyLongBig.multiplyBig(a2, b2);
        System.out.println("MultiplyLong with BigInt method");
        System.out.println(a2 + " x " + b2 + " = " + res2 + "\n" + (a2.multiply(b2).equals(res2)) + "\n");

        BigInteger res3 = MultiplyFastBig.multiplyBig(a2, b2);
        System.out.println("MultiplyFast with BigInt method");
        System.out.println(a2 + " x " + b2 + " = " + res3 + "\n" + (a2.multiply(b2).equals(res3)));
    }
}
