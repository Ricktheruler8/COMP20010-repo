package com.comp20010;

public class Fibonacci {
    static int a = 0;   // Variables used for the fibonacci tail recursive method
    static int b = 1;
    static int c = 0;
    static int counter = 0;

    public static int fibonacciTail(int n) {
        if (n <= 0) {
            return n;
        } else if (counter <= 1) {
            System.out.print(" " + counter);
            counter++;
            n--;
        }
        c = a + b;
        a = b;
        b = c;
        System.out.print(" " + c);

        return fibonacciTail(n - 1);
    }
}
