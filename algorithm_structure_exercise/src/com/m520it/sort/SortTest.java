package com.m520it.sort;

import java.util.Arrays;


/**
 * 结论:
 *   两种排序方式的花费时间的比较
 *         选择排序花费的时间远远小于冒泡排序
 *             原因:因为选择排序知识找到最小的元素,然后将最小的元素,置换到前面,只进行了一次元素的置换
 *                  但是冒泡排序,数组的两两元素进行比较,符合条件就进行置换,需要进行多次的数组元素间的置换
 *                  因此花费的时间将更多
 */
public class SortTest {
    public static void main(String[] args) {
        //测试冒泡排序
       /* BubbleSort bubbleSort=new BubbleSort();
        int[] arr={3,9,-1,10,-2};
        int[] sortArr = bubbleSort.bubbleSortMethod(arr);
        System.out.println(Arrays.toString(sortArr));

        //计算大量数据进行排序,所需要花费的时间

        //定义一个数组
        int[] arr2=new int[80000];
        //往数组中添加数据
        for (int i = 0; i < arr2.length; i++) {
            //定义一个变量,用来随机产生数字
            int i1 = (int) (Math.random() * 80000);
            //向数组中添加80000个数据
            arr2[i]=i1;
        }
        Long startTime=System.currentTimeMillis();
        //对80000个数据进行排序
        bubbleSort.bubbleSortMethod(arr2);
        Long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);*/

       //测试选择排序
        SelectSort selectSort=new SelectSort();
        int[] arr={2,-1,4,-2};
        int[] selectArr = selectSort.realSelectSortMethod(arr);
        System.out.println(Arrays.toString(selectArr));

        //测试选择排序,排序80000个元素时,花费的时间
        //定义一个数组
        int[] arr2=new int[80000];
        //往数组中添加数据
        for (int i = 0; i < arr2.length; i++) {
            //定义一个变量,用来随机产生数字
            int i1 = (int) (Math.random() * 80000);
            //向数组中添加80000个数据
            arr2[i]=i1;
        }
        Long startTime=System.currentTimeMillis();
        //对80000个数据进行排序
        selectSort.realSelectSortMethod(arr2);
        Long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);



    }
}
