package com.m520it.stack;

import java.util.Scanner;

/**
 * 数组模仿栈的实现原理
 *    *先进后出
 */
public class ArraySimulationStack {
    public static void main(String[] args) {

        //创建一个操作栈的对象
        SimulationStack stack=new SimulationStack(4);
        String key=" ";
        //创建一个变量,用来判断是否退出循环
        boolean flag=true;
        while(flag){
            System.out.println("输入show:展示栈中的所有的数据");
            System.out.println("输入exit:退出操作");
            System.out.println("输入push:向栈中添加数据");
            System.out.println("输入pop:栈中的数据,单个的弹出");
            Scanner scanner = new Scanner(System.in);
            key=scanner.next();
            switch (key){
                case "show":
                    stack.getAllData();
                    break;
                case "exit":
                    flag=false;
                    break;
                case "push":
                    Scanner scanner1 = new Scanner(System.in);
                    stack.addData(scanner1.nextInt());
                    break;
                case "pop":
                    int data = stack.getData();
                    System.out.println(data);
                    break;
                default:
                    break;
            }
        }
    }
}

//创建一个类,用来对栈的信息进行封装,和添加
class SimulationStack{

    private int maxSize;  //数组的最大存储的容量
    private int[] stack;  //创建一个数组,用来封装数据,模拟栈
    private int top=-1;      //表示栈顶,添加一个数据,top+1,弹出一个数据:top-1

    //创建一个构造方法,用来初始化栈的信息

    public SimulationStack(int maxSize) {
        this.maxSize = maxSize;
        //初始化数组的最大的存储容量
        stack=new int[maxSize];
    }

    //创建一个方法,用来判断栈是否满了
    public boolean isFull(){
        return top==maxSize-1;
    }

    //创建一个方法,判断栈是否为空
    public boolean isEmpty(){
        return top==-1;
    }

    //创建一个方法,向数组中添加数据
    public void addData(int data){
        if (isFull()){
            System.out.println("栈内的数据已满,栈溢出");
            return;
        }
        top++;
        stack[top]=data;
    }

    //创建一个方法,用来弹出数据
    public int getData(){
        if (isEmpty()){
            throw new RuntimeException("栈中没有数据,不能输出数据");
        }
        int data = stack[top];
        top--;
        return data;
    }

    //创建一个方法,用来迭代出栈中的数据
    public void getAllData(){
        for (int i = top; i >=0; i--) {
            System.out.println(stack[i]);
        }
    }
}
