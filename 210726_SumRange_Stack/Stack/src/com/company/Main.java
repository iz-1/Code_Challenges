package com.company;

public class Main {

//    Problem 2:
//    Write a program and show how to implement stack using Linked List in java.
//        (note: implement your own linked list or use the one provided by java)
    public static void main(String[] args) {
	// write your code here
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
    }
}
