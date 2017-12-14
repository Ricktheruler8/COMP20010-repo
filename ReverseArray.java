package com.comp20010;

//Q8 practical 1

import java.util.Random;

public class ReverseArray {

    public static void reverse(int[] a){
        int last = a.length - 1;
        int tmpFirst, tmpLast;

        for(int start = 0; start < a.length /2; start++){

                tmpFirst = a[start];
                tmpLast = a[last];

                a[start] = tmpLast;
                a[last] = tmpFirst;

                last--;
        }
    }

    public static void main(String[] args){
        int N = 10;
        int[] a = new int[N];
        Random random = new Random();
        for(int i = 0; i < N; ++i){
            a[i] = random.nextInt(100);
        }
        System.out.println("Original array: " + ToStringMethod.toString(a));
        reverse(a);
        System.out.println("Reversed array; " + ToStringMethod.toString(a));
    }
}
