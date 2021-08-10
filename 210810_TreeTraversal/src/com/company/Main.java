package com.company;

import java.util.*;

public class Main {

    //Logical Reasoning:
    //What day is the fourteenth of a given month?
    //I. The last day of the month is a Wednesday.
    //II. The third Saturday of the month was seventeenth.
    //
    //(a) if the data in statement I alone are sufficient to answer the question;
    //(b) if the data in statement II alone are sufficient to answer the question;
    //(c) if the data either in I or II alone are sufficient to answer the question;
    //(d) if the data even in both the statements together are not sufficient to answer the question;
    //(e) if the data in both the statements together are needed;
    //
    //Each Question given below has a problem and three statements numbered I,II and III giving certain information.
    // You have to decide if the information given in the statements is sufficient for answering the problem.
    // Remember out of the three statements, each of them alone can also be sufficient to answer the question.
    // In such cases for example, your answer should be taken as Only I or Only II or Only III and not Only I.
    //
    //Answer: d

    // Write java program to do level order traversal of binary tree. You can use queue data structure to do level order traversal.
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(2);
        bt.add(4);
        bt.add(1);
        bt.add(3);
        bt.add(5);
        bt.add(9);
        //bt.print();
        bt.printLevel();
    }
}
