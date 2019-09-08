package com.m520it.queue;


import java.util.Scanner;

public class QueueArrayDemo {

    //用数组模拟队列(先进先出)
    public static void main(String[] args) {

        //测试数组模拟的队列
        QueueArray queueArray=new QueueArray(3);
        //数据的添加通过控制台进行控制
        Scanner scanner=new Scanner(System.in);
        //获取控制台输入的第一个值
        char cValue = ' ';
        boolean loop=true;
        while(loop){
            System.out.println("输入s:展示队列中所有的数据");
            System.out.println("输入a:向队列中添加一个数据");
            System.out.println("输入g:从队列中取出一个数据");
            System.out.println("输入q:展示队列的头信息的数据");
            System.out.println("输入e:退出程序");
            //获取控制台输入的第一个数据
            cValue=scanner.next().charAt(0);
            switch(cValue){
                case 's':
                    try {
                        int[] arrayAllMessage = queueArray.getAllMessage();
                        for (int i : arrayAllMessage) {
                            System.out.println(i);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    Scanner scanner1=new Scanner(System.in);
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
                        int queueData = queueArray.showHeadQueueData();
                        System.out.println(queueData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("哈哈哈!");
                    loop=false;
                    break;
            }
        }
    }
}

class QueueArray{

    private int maxSize;//数组的最大的容量
    private int front;  //队列头部的前一个的数据的索引的位置(默认第一个是-1),用来记录数据的取出:取出一个加一
    private int rear;   //队列尾部的最后一个索引的位置,用来记录数组数据的添加:添加一个加一
    private int[] intArr;

    //创建一个构造器,用来给类的属性赋值
    public QueueArray(int ArrMaxSize){
        this.maxSize=ArrMaxSize;
        this.front=-1;
        this.rear=-1;
        intArr=new int[ArrMaxSize];
    }

    //判断数组是否存储已满
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //向队列中添加数据
    public void addData(int data){
        //判断队列是否已经存满数据,如果存储满了,则提示队列已满,不能添加数据
        if (isFull()){
            throw new RuntimeException("队列已满,不能添加数据");
        }
        rear++;
        intArr[rear]=data;
    }

    //从队列中取出数据
    public int getData(){
        //判断队列是否为空,如果为空,则不能取出数据
        if(isEmpty()){
            throw new RuntimeException("队列为空,不能取出数据");
        }
        front++;
        int data = intArr[front];
        //返回取出的数据
        return  data;
    }

    //显示队列的头信息
    public int showHeadQueueData(){
        //判断队列是否为空,如果为空,则不能取出数据
        if(isEmpty()){
            throw new RuntimeException("队列为空,不能显示头信息");
        }
        return  intArr[front+1];
    }

    public int[] getAllMessage(){
        if (intArr.length==0){
            throw new RuntimeException("数组为空,不能得到数据");
        }
        return intArr;
    }
}
