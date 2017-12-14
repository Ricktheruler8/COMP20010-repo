package com.comp20010;

// Q2 practical 1

public class ArrayEquals {

    public static boolean eq(int[] a, int[] b){

        if(a.length == b.length){
            for (int i = 0; i < a.length; ++i){
                if(a[i] != b[i]){
                    return false;
                }
            }
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args){
        int[] a = {3,1,4,1,5};
        int[] b = {3,1,4,1};
        int[] c = {3,1,4,1,5};
        int[] d = {2,7,1,8,2};

        System.out.println(eq(a,a));
        System.out.println(eq(a,b));
        System.out.println(eq(a,c));
        System.out.println(eq(a,d));
    }
}
