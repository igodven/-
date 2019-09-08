package com.m520it.queue;

import java.util.Scanner;

public class CircleQueueArrayDemo {

    //循环队列的实现过程
    public static void main(String[] args) {

        //测试数组模拟的队列
        CircleQueueArray queueArray = new CircleQueueArray(4);
        //数据的添加通过控制台进行控制
        Scanner scanner = new Scanner(System.in);
        //获取控制台输入的第一个值
        char cValue = ' ';
        boolean loop = true;
        while (loop) {
            System.out.println("输入s:展示队列中所有的数据");
            System.out.println("输入a:向队列中添加一个数据");
            System.out.println("输入g:从队列中取出一个数据");
            System.out.println("输入q:展示队列的头信息的数据");
            System.out.println("输入e:退出程序");
            //获取控制台输入的第一个数据
            cValue = scanner.next().charAt(0);
            switch (cValue) {
                case 's':
                    try {
                         queueArray.getAllMessage();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    Scanner scanner1 = new Scanner(System.in);
                    int nextInt = scanner1.nextInt();
                    try {
                        queueArray.addData(nextInt);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int firstData = queueArray.getData();
                        System.out.println(firstData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'q':
                    try {
                        int queueData = queueArray.getHeadMessage();
                        System.out.println(queueData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("哈哈哈!");
                    loop = false;
                    break;
            }
        }
    }

}

class CircleQueueArray {

    //队列总存储数据的最大的容量
    private int maxSize;
    //队列中指明取出数据的指针,取出一个数据,指针移动一位(初始值为0)
    private int front;
    //队列中指明添加数据的指针,添加一个数据,指针移动一位(初始值为0)
    private int rear;
    //定义一个数组,用来保存队列的数据
    private int[] intArr;

    public CircleQueueArray() {

    }

    public CircleQueueArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.intArr = new int[arrMaxSize];
    }

    //判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //向队列中添加数据
    public void addData(int data) {
        if (isFull()) {
            throw new RuntimeException("队列已满,不能添加数据");
        }
        intArr[rear] = data;
        //添加数据后,指针应该移动一位,因为要做到循环的话,用取模的方式,循环的设置rear的值
        /**
         * 队列设置满后,如果队列还有空位,它又会从起始的位置开始进行赋值
         */
        this.rear = (rear + 1) % maxSize;
    }

    //从队列中取出数据
    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取出数据");
        }
        int data = intArr[front];
        //取出数据后,指针应该移动一位,用取模的方式,达到循环设置front的值
        /**
         * 值取完后,又会返回从索引为0的位置,重新取值,先进先出的概念
         */
        this.front = (front + 1) % maxSize;
        return data;
    }

    //得到所有的数据信息
    public void getAllMessage() {
        if (isEmpty()){
            throw new RuntimeException("队列为空,不能取出数据");
        }
        //数据应该从取出后的指针指定的位置开始取值
        for (int i = front; i < front + getSize(); i++) {
            /**
             * i%maxSize:取模,可以获取索引为0,1
             */
            System.out.println(i % maxSize + "==>" + intArr[i % maxSize]);
        }
    }

    //得到队列中实际的有效的数据的个数
    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }

    //得到队列的头信息
    public int getHeadMessage() {
        if (isEmpty()) {
            throw new RuntimeException("不能取出关于头信息的值,因为队列为空");
        }
        return intArr[front];
    }
}
