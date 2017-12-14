package com.comp20010;


import java.util.Scanner;

public class TestFibonacci {

    public static void testFibonacci(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number that will be the nth fibonacci sequence");
        int fib = sc.nextInt();
        Fibonacci.fibonacciTail(fib);
    }
}
