package com.m520it.sort;

import java.util.Arrays;

/**
 * 插入排序的实现分析
 * 1.将初始数组分成两个数组(假想的数组),有序的数组,无序的数组
 * 2.刚开始,有序的数组只包含一个元素,arr[0]
 * 3.初始数组的其他元素组成无序数组,从无序数组中依次取出元素,和有序数组的元素进行依次比较
 * 4.如果无序数组中取出的元素 < 有序数组中的元素,则将有序数组的元素后移(大的元素全部置于后面),否则,跳出循环
 * 5,并且将无序元素中取出的元素,插入有序数组中
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr={2,-1,4,-15,8,9,3,-3};
        int[] insertArr = insertSortMethod(arr);
        System.out.println(Arrays.toString(insertArr));
    }
    public static int[] insertSortMethod(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int indexVal = arr[i];//无序数组中取出的元素
            int index = i - 1;    //无序数组取出元素的前一个的索引
            /**
             * index <= 0:跳出循环,因为索引不可能小于零
             * arr[i] < arr[index]:判断后一个元素是否小于前一个元素,如果符合条件,则将前一个元素后移
             */
            while (index >= 0 && indexVal < arr[index]) {
                //将元素后移
                arr[index+1]=arr[index];
                //将index进行减一的操作,进行接下来的循环的比较
                index--;
            }
            //跳出循环后,将无序数组取出的元素,置于它应该属于的位置
            arr[index+1]=indexVal;
        }
        return arr;
    }
}
