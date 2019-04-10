package com.example.demo.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 快速排序
public class QuickList {

    private static List<Integer> list = new ArrayList<>();

    private static int count = 0;

    public static void main(String[] args){
        List temp = Arrays.asList(5,3,8,6,4);
        list.addAll(temp);
        quickList(0, temp.size()-1);
        System.out.println(" count =" + count);
    }

    public static void quickList(int left, int right){
        count++;
        Integer t, temp, l = left, r = right;
        if(left >= right){ return; }
        temp = list.get(left); // 定义基数
        while (l != r) {
            while( list.get(r) >= temp && l < r){
                r --;
            }
            while (list.get(l) <= temp && l < r){
                l ++;
            }
            if( l < r ){
                t = list.get(r);
                list.set(r, list.get(l));
                list.set(l, t);
            }
        }
        list.set(left, list.get(l));
        list.set(l, temp);
        // 递归
        quickList(left, l-1);
        quickList(l+1, right);
    }
}
