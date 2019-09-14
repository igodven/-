package com.m520it.sort;

/**
 * 选择排序
 * *实现的原理
 * 1.找出数组中的最小值,记录其的索引下标,和他的值,将其置换到数组的第一个的位置
 * 2.然后从数组的第二个位置,开始找到数组的最小值,记录其的索引下标,和他的值,将其置换到数组的第二个位置
 * 3.依次方法,直到排序数组长度-1次
 */
public class SelectSort {

    /**
     * 选择排序算法的拆分分析
     *
     * @param arr
     * @return
     */
    public int[] selectSortMethod(int[] arr) {

        //先进行第一轮的置换
        //先假设数组的第一个值就是最小值
        int index = 0;//最小值的索引
        int min = arr[0];//最小值

        //对数组循环迭代,找出最小的值
        for (int i = 0 + 1; i < arr.length; i++) {
            if (min > arr[i]) {
                index = i;
                min = arr[i];
            }
        }

        //将找出的最小的值,进行数组的置换
        /**
         * 可以进行小小的优化,当数组需要置换的值刚好位于这个位置,则不用进行数组元素的调换
         */
        if (index != 0) {
            arr[index] = arr[0];
            arr[0] = min;
        }


        //先进行第二轮的置换
        //先假设数组的第一个值就是最小值
        index = 1;//最小值的索引
        min = arr[1];//最小值

        //对数组循环迭代,找出最小的值
        for (int i = 1 + 1; i < arr.length; i++) {
            if (min > arr[i]) {
                index = i;
                min = arr[i];
            }
        }

        //将找出的最小的值,进行数组的置换
        /**
         * 可以进行小小的优化,当数组需要置换的值刚好位于这个位置,则不用进行数组元素的调换
         */
        if (index != 1) {
            arr[index] = arr[1];
            arr[1] = min;
        }
        return arr;
    }

    public int[] realSelectSortMethod(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int index = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    index = j;
                    min = arr[j];
                }
            }
            if (index != i) {
                //必须保证顺序,否则排序出错
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }
}
