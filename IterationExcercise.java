package com.comp20010;

// Q4 practical 1

public class IterationExcercise {

    public static int[] copyArray(int [] a){
        int[] b = new int[a.length];

        for(int i = 0; i < a.length; ++i){

            b[i] = a[i];
        }
        return b;
    }

    public static void main(String[] args){
        int[] a = {56,14,-46,15,36,99,77,18,29,49};

        int[] b = copyArray(a);

        a[0] = -1;
        int i = 0;
        while(i < a.length){
            System.out.println(b[i]);
            i++;
        }
        System.out.println();

        System.out.println(ToStringMethod.toString(b));
     }
}
