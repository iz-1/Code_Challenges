package com.company.BTree;

import java.text.MessageFormat;
import java.util.*;

public class BinaryTree {
    TreeNode head;

    public BinaryTree(){
        head = null;
    }

    protected void traverse(TreeNode node, StringBuffer sb){
        if(node == null)
            return;
        //sb.append(node.getItem());
        sb.append(MessageFormat.format("{0}{1}", node.getItem(), System.getProperty("Line.separator")));
        traverse(node.getLeft(), sb);
        traverse(node.getRight(), sb);
    }

    protected void levelTraverse(int level, TreeNode node, Queue<AbstractMap.SimpleEntry<Integer, Integer>> que) {
        if(node == null)
            return;
        que.add(new AbstractMap.SimpleEntry<>(level, node.getItem()));
        levelTraverse(level+1, node.getLeft(), que);
        levelTraverse(level+1, node.getRight(), que);
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

    public void printLevel(){
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> que = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        levelTraverse(0, head, que);
        for(AbstractMap.SimpleEntry<Integer, Integer> e : que)
            sb.append(MessageFormat.format("level {0} value {1}{2}", e.getKey(), e.getValue(), System.getProperty("line.separator")));
        System.out.println(sb.toString());
    }

    public static BinaryTree toBalancedBinaryTree(int[] sortedArray) {
        BinaryTree bTree = new BinaryTree();
        BinaryTree.insertBalanced(0, sortedArray.length, sortedArray, bTree);
        return bTree;
    }

//    1) Get the Middle of the array and make it root.
//    2) Recursively do same for left half and right half.
//    a) Get the middle of left half and make it left child of the root
//    created in step 1.
//    b) Get the middle of right half and make it right child of the
//    root created in step 1.
    protected static void insertBalanced(int rangeStart, int rangeEnd, int[] array, BinaryTree bTree) {
        int len = rangeEnd - rangeStart;
        if(len < 1)
            return;
        int middle = (len-1 >> 1) + rangeStart;
        bTree.add(array[middle]);
        insertBalanced(rangeStart, middle, array, bTree);
        insertBalanced(middle+1, rangeEnd, array, bTree);
    }

//    protected static void insertBal(int[] array, BinaryTree bTree) {
//        if(array.length == 0)
//            return;
//        int middle = (array.length-1) >> 1;
//        bTree.add(array[middle]);
//            // left middle
//        int left[] = Arrays.copyOfRange(array, 0, middle);
//        insertBal(left, bTree);
//            // right middle
//        int right[] = IntStream.range(middle+1, array.length).map(i->array[i]).toArray();
//        insertBal(right, bTree);
//    }
}
