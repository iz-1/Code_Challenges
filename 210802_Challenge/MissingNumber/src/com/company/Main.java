package com.company;

import java.text.MessageFormat;

public class Main {
/*
    Problem 2: Write java Program to Find Smallest and Largest Element in an Array.
    Note: Number can not be repeated in the array.
*/
    public static void main(String[] args) {
        int[] arr1={7,5,6,1,4,2};
        Integer miss1 = MissingNumber.find(arr1);
        System.out.println(MessageFormat.format("Missing number : {0}", miss1));
        //Missing number : 3

        int[] arr2={5,3,1,2};
        Integer miss2 = MissingNumber.find(arr2);
        System.out.println(MessageFormat.format("Missing number : {0}", miss2));
        //Missing number : 4
    }
}
