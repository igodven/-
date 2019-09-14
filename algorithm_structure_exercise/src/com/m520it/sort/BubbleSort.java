package com.m520it.sort;

/**
 * 纯手书写冒泡排序
 */
public class BubbleSort {

    /**
     * 定义一个方法,封装了冒泡排序的具体的操作,传入一个数组,会根据数组进行相关的排序的操作
     * 原理分析:
     *      1.根据数组的索引,获取相邻两个索引的值,将其值进行比较
     *      2.如果第一个的值大于第二个的值,则两个索引的值进行交换,否则不交换
     *      3.比较完之后,将索引进行加一,在进行下一此的比较,知道,将最大的值,置于最后的索引
     *      4.进行下次的轮流的比较知道比较数组的长度-1次,才结束
     */
    public int[] bubbleSortMethod(int[] arr){

        //创建一个临时的变量,用来存储临时数组的值,用来值的大小的交换
        int temp=0;
        //定义一个变量,用来对冒泡排序的优化
        boolean flag=false;
        for (int i = 0; i <arr.length-1 ; i++) {

            for (int j = 0; j < arr.length-1-i; j++) {
                //对一个数组的值,进行两两的比较,满足条件后,进行置换,知道把最大的值,替换到最后
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            /**
             * 冒泡排序的优化
             *      如果数组的比较没有进行置换,说明数组已经排好序了,可以直接跳出循环,节省比较的时间
             */
            if (!flag){
                break;
            }else{
                //每交换一次,flag的变量都会置为true,如果不把flag置为flase,值这个优化就没有意义
                flag=false;
            }
        }
        return arr;

    }
}
