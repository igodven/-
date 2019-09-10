package com.m520it.linkedlist;

public class StudentNodeManage {

    //创建一个头节点,用来连接各节点
    StudentNode stuNode = new StudentNode(0, "", "");

    //创建一个方法,用来添加节点
    public void addNode(StudentNode studentNode) {
        //创建一个临时的节点,用来指向节点的移动(循环迭代的判断)
        StudentNode temp = stuNode;
        //循环迭代,判断哪个节点的next为null,则在其后面添加新的节点,并且和上一个节点建立联系
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            //把节点向后移动一位
            temp = temp.getNext();
        }
        //将最后节点的next指向新创建的节点
        temp.setNext(studentNode);
        //将新创建的节点的前一个节点,指向前最后一个节点
        studentNode.setPre(temp);
    }

    //查询所有的节点的信息
    public void getNodesMessage() {
        //创建一个临时的节点,相当于一个指针,循环判断节点.next是否为null,为null跳出循环
        StudentNode temp = stuNode;
        while (true) {
            System.out.println(temp);
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
    }

    //对双向链表的节点进行更改
    public void updateNode(StudentNode studentNode){
        //创建有个临时的节点,用来辅助查找到要修改的指定的节点
        StudentNode temp=stuNode.getNext();
        //循环迭代,找到需要修改的节点
        while(true){
            if (temp==null){
                System.out.println("没有找到需要修改的链表的信息");
                break;
            }else if(temp.getStuNo()==studentNode.getStuNo()){
                temp.setStuName(studentNode.getStuName());
                temp.setStuNickName((studentNode.getStuNickName()));
                System.out.println("修改成功");
                break;
            }
            temp=temp.getNext();
        }
    }

    //删除指定的节点
    public void delNode(int no){
        /**
         * 思路:
         *    1.找到需要删除的节点
         *    2.将删除节点的后一个节点和删除节点的前一个节点建立联系
         *      2.1将需要删除的节点.next指向删除节点的.pre.next   (delNode.pre.next=delNode.next)
         *      2.2将需要删除节点.pre指向删除节点的.next.pre      (delNode.next.pre=delNode.pre)
         */
        //创建一个临时的节点,用来辅助找到需要删除的节点
        StudentNode temp=stuNode.getNext();
        while(true){
            if (temp==null){
                System.out.println("没有找到需要删除的节点,请重新输入正确的学生的编号");
                break;
            }else if (temp.getStuNo()==no){
                temp.getPre().setNext(temp.getNext());
                temp.getNext().setPre(temp.getPre());
                System.out.println("删除成功");
                break;
            }
            temp=temp.getNext();
        }
    }
}
