package com.comp20010;

import java.math.BigInteger;
import java.util.Random;

public class TimeFastMultiply {

    public static double fastTime(int n, Random rand) {
        long iterations = 0;
        long iterationsPerRound = 10;
        long begin = System.currentTimeMillis();
        long end;
        long n_seconds = 2;
        long t_max = 1000L * n_seconds;
        BigInteger a = RandomBig.randomBigInteger(n,rand);
        BigInteger b = RandomBig.randomBigInteger(n,rand);

        do {
            for (long i = 0; i < iterationsPerRound; ++i) {
                BigInteger res = MultiplyFastBig.multiplyBig(a, b);
            }
            end = System.currentTimeMillis();
            iterations += iterationsPerRound;
            iterationsPerRound = (long) (iterationsPerRound * 1.6);
        } while (iterations < Integer.MAX_VALUE / 2 &&//
                ((end - begin) < t_max));
        return (0.001d * (end - begin)) / iterations;
    }
}
