package com.company;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> implements IStack<T> {
    List<T> llist = new LinkedList<>();

    @Override
    public void push(T x) {
        llist.add(x);
    }

    @Override
    public T peek() {
        if(isEmpty())
            return null;
        return llist.get(llist.size() - 1);
    }

    @Override
    public T pop() {
        if(isEmpty())
            return null;
        return llist.remove(llist.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return llist.isEmpty();
    }
}
