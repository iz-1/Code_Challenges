package com.company;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MissingNumber {
    static Integer find(int[] arr) {
        //List<Integer> arrList = new ArrayList<>();
        //for(int i : arr) arrList.add(i);

        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(arrList);
        for(Integer i=0; i<arrList.size(); ++i) {
            if(arrList.get(i) != arrList.get(0) + i)
                return arrList.get(0) + i;
        }
        return -1;
    }

    static Integer findNoSort(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for(int i : arr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        //System.out.println(MessageFormat.format("min: {0} max: {1}", min, max));
        for(int i=min; i<max; ++i) {
            //System.out.println(MessageFormat.format("i: {0}", i));
            boolean found = false;
            for (int j = 0; j < arr.length; ++j) {
                if (arr[j] == i) found = true;
            }
            if(!found) return i;
        }
        return -1;
    }
}
