package com.m520it.linkedlist;

import java.util.Stack;

public class InterviewSingleLinkedListDemo {
    public static void main(String[] args) {

        //创建节点的信息
        HerosNode heroNode1 = new HerosNode(1, "宋江", "及时雨");
        HerosNode heroNode2 = new HerosNode(2, "卢俊义", "玉麒麟");
        HerosNode heroNode3 = new HerosNode(3, "吴用", "智多星");
        HerosNode heroNode4 = new HerosNode(4, "林冲", "豹子头");
        //将节点的信息加入链表中
        SingleLinkListManage manage=new SingleLinkListManage();
        manage.addNode(heroNode1);
        manage.addNode(heroNode2);
        manage.addNode(heroNode3);
        manage.addNode(heroNode4);
        //计算有效的节点的个数
        int validNode = manage.getValidNode();
        System.out.println(validNode);

        //得到倒数第k的节点的值
        manage.getlastNode(4);

        //逆向打印节点的信息
        manage.getReverseNode();
    }
}

//创建一个节点,用来存储节点的信息
class HerosNode{

    public int no;
    public String name;
    public String nickName;
    public HerosNode next;

    public HerosNode(int no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }
    //无参构造器
    public HerosNode(){}

    @Override
    public String toString() {
        return "HerosNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

//创建一个类,用来创建节点,并且对节点进行增删改的操作
class SingleLinkListManage {

    //创建一个头节点,用来对新增的节点进行连接
    HerosNode herosNode = new HerosNode(0, "", "");

    //定义一个方法,用来增加节点,连接节点的关系
    public void addNode(HerosNode node){
        //创建一个临时的节点,用来对节点的指定
        HerosNode temp=herosNode;
        //对节点进行循环迭代,找到末尾的节点,进行节点的赋值
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
    }

    //计算链表的有效的节点的个数
    public int getValidNode(){
        //定义一个临时的节点,用来指向有效的节点
        HerosNode temp=herosNode;
        //定义一个变量,用来计算有效节点的个数
        int count=0;
        //判断头节点是否有下一个节点,如果没有直接返回0,不会进行循环迭代的判断
        if (temp.next==null){
            return 0;
        }else {
            while(true){
                if (temp.next==null){
                    break;
                }else{
                    count++;
                    temp=temp.next;
                }
            }
            return count;
        }
    }


    //查找链表中的倒数的第k个节点
    public void getlastNode(int lastIndex){
        //定义一个临时的节点,用来指定节点
        HerosNode temp=herosNode.next;
        /**
         * 思路:1.计算有效的节点的个数,通过循环迭代的方法:size
         *     2.通过循环迭代的方法,利用size-lastIndex,循环迭代出需要的节点
         */
        //调用getValidNode()方法,计算有效的节点数
        int size=getValidNode();
        //如果指定的k大于有效的个数,或者输入的值小于零,则提醒输入的值有误
        if (lastIndex<0||lastIndex>size){
            System.out.println("输入的值有误,请重新输入!");
        }
        if (temp.next!=null){
            for (int i = 0; i <size-lastIndex; i++) {
                temp=temp.next;
            }
        }
        System.out.println(temp);
    }


    //定义一个方法,从头到位打印节点
    /**
     * 思路分析:
     *      方法一:
     *         1.遍历所有的节点
     *         2.每遍历一个节点,就将该节点加入栈中,因为栈的特点:先进后出
     *      方法二:
     *         将节点反转,然后再将节点循环迭代打印
     *
     */

    public void getReverseNode(){
        //创建一个临时的节点,方便节点的循环的迭代
        HerosNode temp=herosNode.next;
        //如果没有节点,或者只有一个节点,则无需逆向打印节点的信息
        if (temp==null){
            return;
        }
        Stack<HerosNode> stack=new Stack<>();
        while(true){
            if (temp!=null){
                stack.push(temp);
            }else{
                break;
            }
            temp=temp.next;
        }
        //打印逆向的节点的信息
       while (stack.size()>0){
           HerosNode node = stack.pop();
           System.out.println(node);
       }
    }
}
