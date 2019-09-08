package com.m520it.linkedlist;

public class SingleLinkedListDemo {
    //单向列表的实现的原理
    public static void main(String[] args) {

        //创建英雄的信息,把英雄的信息加入节点中
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList=new SingleLinkedList();
           singleLinkedList.addNodeByOrder(heroNode1);
           singleLinkedList.addNodeByOrder(heroNode3);
           singleLinkedList.addNodeByOrder(heroNode4);
           singleLinkedList.addNodeByOrder(heroNode2);

        //取出节点的信息
        singleLinkedList.getHeroNode();

        //对节点的信息进行更改
//        HeroNode heroNode5 = new HeroNode(4, "小宠", "小猫");
//        singleLinkedList.updateNodeMessage(heroNode5);
//        System.out.println("修改后的节点的信息======>");
//        singleLinkedList.getHeroNode();

        //删除节点
        singleLinkedList.delNode(2);
        singleLinkedList.delNode(1);
        singleLinkedList.delNode(2);
        singleLinkedList.delNode(3);
        singleLinkedList.delNode(4);
        System.out.println("展示删除后的链表的信息");
        singleLinkedList.getHeroNode();
    }
}


//创建一个类,用来增加节点
class SingleLinkedList{

    //初始化一个head的头信息,用来指定下一个的节点的信息,方便节点的添加
    HeroNode head=new HeroNode(0,"","");

    //创建一个方法,用来添加节点
    public void add(HeroNode heroNode){
        //从尾部开始添加
        //创建一个临时的英雄节点,用来判断该节点的next是否为null,如果为null,则添加到该节点的尾部
        HeroNode temp=head;
        while(true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        //如果跳出了循环,则说明指向了最后一个节点,可以向尾部添加英雄的信息
        temp.next=heroNode;
    }

    //通过英雄的编号进行节点的添加(节点的排序),如果编号存在,则不添加
    public void  addNodeByOrder(HeroNode heroNode){
        boolean flag=false;
        //创建一个临时的节点信息,相当于一个指针,用来指定节点的信息
        HeroNode temp=head;
        //对节点进行循环迭代,判断编号的位置,然后进行节点的存储
        while(true){
            //如果temp.next为null,则向尾部进行添加
            if (temp.next==null){
                break;
            }
            //如果temp的下一个节点的编号,大于添加节点的编号,则跳出循环
            if (temp.next.no>heroNode.no){
                break;
            }
            //如果temp的下一个节点的编号等于添加节点的编号,则跳出循环
            if (temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("该编号已经存在,请重新添加");
            return;
        }else {
            //进行节点的转换,排序:新的节点.next指向临时节点的下一个节点,临时节点的下一个节点的信息指向新添加的节点
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //创建一个方法,对节点的信息进行更改,根据节点的编号进行更改
    public  void updateNodeMessage(HeroNode heroNode){

        //创建一个临时的节点,用来对节点的指向,相当于一个指针
        HeroNode temp=head;
        //创建一个flag用来判断该节点是否存在
        boolean flag=false;
        //对现有的全部节点信息进行循环迭代
        while(true){
            if (temp.next==null){  //迭代到最后一个节点,如果节点为null,则跳出循环
                break;
            }
            if (temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next.name=heroNode.name;
            temp.next.nickName=heroNode.nickName;
        }else{
            System.out.println("该编号的英雄不存在,请重新输入");
        }
    }


    //创建一个方法,对节点的信息进行删除 根据节点的编号进行删除
    public void delNode(int no){
        //创建一个临时的节点,用来指定节点(相当于指针)
        HeroNode temp=head;
        boolean flag=false;
        while(true){
            if (temp.next==null){//该链表的最后一个节点
                break;
            }
            if (temp.next.no == no) {//找到要删除的节点
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next=temp.next.next;
        }else {
            System.out.println("该节点不存在,不能删除");
        }
    }

    //创建一个方法,获取链表中的英雄的数据的信息
    public void getHeroNode(){
        //创建一个临时节点,用来指定下一个节点的信息,判断是否有下一个节点,有就取出
        HeroNode temp=head;
        while(true){
            //如果temp的值为null,则跳出循环
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
}

//创建一个英雄的节点,用来存储英雄的相关的信息,还包括指向下一个英雄的节点的信息
class HeroNode{

     int no;//英雄的编号
     String name;//英雄的姓名
     String nickName;//英雄的昵称
     HeroNode next;//英雄的下一个的节点的信息

    public HeroNode(int no,String nickName,String name){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}