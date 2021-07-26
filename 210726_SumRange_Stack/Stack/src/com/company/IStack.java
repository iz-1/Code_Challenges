package com.company;

//Push: Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
//        Pop: Removes an item from the stack. ...
//        Peek or Top: Returns top element of stack.
//        isEmpty: Returns true if stack is empty, else false.
public interface IStack<T> {
    void push(T x);
    T peek();
    T pop();
    boolean isEmpty();
}