package com.company;

import java.text.MessageFormat;
import java.util.*;

public class BinaryTree {
    TreeNode head;

    public BinaryTree(){
        head = null;
    }

    public TreeNode getHead() {
        return head;
    }

    public void add(Integer item) {
        if(head == null) {
            head = new TreeNode(item);
            return;
        }

        TreeNode node = head;
        while(node != null) {
            if(item > node.getItem()) {
                if(node.getRight() != null)
                    node = node.getRight();
                else {
                    node.setRight(new TreeNode(item));
                    return;
                }
            } else {
                if(node.getLeft() != null)
                    node = node.getLeft();
                else {
                    node.setLeft(new TreeNode(item));
                    return;
                }
            }
        }
    }

    public void print(){
        StringBuffer sb = new StringBuffer();
        traverse(head, sb);
        System.out.println(sb.toString());
    }

    public void traverse(TreeNode node, StringBuffer sb){
        if(node == null)
            return;
        //sb.append(node.getItem());
        sb.append(MessageFormat.format("{0}{1}", node.getItem(), System.getProperty("Line.separator")));
        traverse(node.getLeft(), sb);
        traverse(node.getRight(), sb);
    }

    public void printLevel(){
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> que = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        levelTraverse(0, head, que);
        for(AbstractMap.SimpleEntry<Integer, Integer> e : que)
            sb.append(MessageFormat.format("level {0} value {1}{2}", e.getKey(), e.getValue(), System.getProperty("line.separator")));
        System.out.println(sb.toString());
    }

    public void levelTraverse(int level, TreeNode node, Queue<AbstractMap.SimpleEntry<Integer, Integer>> que) {
        if(node == null)
            return;
        que.add(new AbstractMap.SimpleEntry<>(level, node.getItem()));
        levelTraverse(level+1, node.getLeft(), que);
        levelTraverse(level+1, node.getRight(), que);
    }
}
