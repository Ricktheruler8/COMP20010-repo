package com.comp20010;

import java.util.Random;

public class RandomLong {

    public static Long getRandomLong(int n, int base) {
        Random rand = new Random();

        long r_min = (long) Power.power(base, n - 1);
        long r_max = (long) Power.power(base, n);

        long r = (long) (r_min + rand.nextDouble() * (r_max - r_min));

        return r;
    }
}
