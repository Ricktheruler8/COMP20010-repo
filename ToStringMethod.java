package com.comp20010;

// Q1 practical 1

public class ToStringMethod {

    public static String toString(int[] a) {

        char temp;
        int tmp;
        String string = " ";

        for (int i = 0; i < a.length; ++i){

            tmp = a[i];

            string += tmp + " ";
        }

        return string;
    }
}
