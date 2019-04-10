package com.example.demo.example;

/**
 * 归并排序
 * 归并的含义：将2个或2个以上的有序表合并成一个新的有序表
 *
 * 多路归并排序
 * 两路归并排序
 *
 * 小数据量 快排  大数据量 归并  均未作特殊处理优化的的。。
 */
public class MergeSort {

    // 把待排序的n个元素的序列分解成两个子列，每个子序列包含n/2个元素
    // 对每个子序列分别调用 归并排序，进行递归操作。
    // 合并两个排好序的子序列，生成排序结果。

    public static void main(String[] args){
        int[] a = {49, 38, 65, 97, 76, 13, 27, 50};
        //  [49, 38, 65, 97] [76, 13, 27, 50]
        //  [49, 38] [65, 97] [76, 13] [27, 50]
        //  [49],[38],[65],[97],[76],[13],[27],[50]
        //  每次拆分 取中间值 分为左右2部分， 且 start < end --> array index
        //  归并
        //
        //  start min end
        //  [38, 49] [65, 97] [13, 76] [27, 50]
        //  [38, 49, 65, 97] [13, 27, 50, 76]
        //  [13, 27, 38, 50, 65, 76, 97]

        mergeSore(a, 0, a.length-1, "main");
        for(int i=0; i< a.length; i++){
            System.out.println("i="+a[i]);
        }
    }

    public static void mergeSore(int[] a, int start, int end,  String flag){
        // 拆分 单个元素  然后 合并
        // 一半半的拆
        System.out.println("flag:"+flag+"--->start="+start+"--->end="+end);
        if(start < end){
            int mid = (start+end)/2;
            mergeSore(a, start, mid, "first");
            mergeSore(a, mid+1, end, "second");
            merge(a, start, mid, end);
        }
    }

    public static void merge(int[] a, int start, int mid, int end){
        int[] temp = new int[a.length]; // 需要辅助数组
        // 归并时 先从2断 找到较小数字 放入 辅助数组。
        int p1 = start, p2 = mid+1, k = start; //
        while (p1 <= mid && p2<= end){
            if(a[p1]<=a[p2]){
                temp[k++] = a[p1++];
            }else{
                temp[k++] = a[p2++];
            }
        }
        while (p1 <= mid){
            temp[k++] = a[p1++];
        }
        while (p2<=end){
            temp[k++] = a[p2++];
        }
        String str = "";
        for(int i=start; i <=end; i++){
            a[i] = temp[i];
            str = str + "," + a[i];
        }
        System.out.println(str);

    }


}
