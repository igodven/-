package com.m520it.linkedlist;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        StudentNode stuNode1=new StudentNode(1,"孙悟空","齐天大圣");
        StudentNode stuNode2=new StudentNode(2,"猪八戒","净坛使者");
        StudentNode stuNode3=new StudentNode(3,"沙和尚","沙悟净");
        StudentNode stuNode4=new StudentNode(4,"唐僧","金蝉子");

        StudentNodeManage manage=new StudentNodeManage();
        //添加节点
        manage.addNode(stuNode1);
        manage.addNode(stuNode2);
        manage.addNode(stuNode3);
        manage.addNode(stuNode4);

        //打印添加的节点
        manage.getNodesMessage();

        //修改节点的信息
        StudentNode stuNode5=new StudentNode(1,"孙行者","斗战胜佛");
        manage.updateNode(stuNode5);
        //打印修改后的链表的信息
        manage.getNodesMessage();

        //删除指定的节点
        manage.delNode(1);
        //打印删除后的链表
        manage.getNodesMessage();

    }
}
