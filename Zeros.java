package com.comp20010;

public class Zeros {

    public static void moveZeros(int[] a){
        int tmp;
        int N = a.length;

        for(int i = 0; i < N; i++){
                for(int j = 1; j < N - i; ++j){
                    if(a[j-1] == 0){
                        tmp = a[j-1];
                        a[j-1] = a[j];
                        a[j] = tmp;
                    }
                }
            }
        }

    public static void main(String[] args) throws IndexOutOfBoundsException{
        int[] a = {0,0,12,0,2,0,0,0,5,0,8};

        System.out.println("Original array: " + ToStringMethod.toString(a));

        moveZeros(a);

        System.out.println("After moving zeros: " + ToStringMethod.toString(a));
    }
}
