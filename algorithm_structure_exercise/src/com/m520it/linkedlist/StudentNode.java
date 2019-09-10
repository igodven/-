package com.m520it.linkedlist;

import java.io.Serializable;

public class StudentNode implements Serializable {

    private int stuNo;     //节点中数据的编号
    private String stuName;  //节点中数据的名字
    private String stuNickName;   //节点中数据的昵称
    private StudentNode next;  //链表中某个节点所对应的下一个节点
    private StudentNode pre;   //链表中某个节点所对应的上一个节点

    public StudentNode(int stuNo, String stuName, String stuNickName) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuNickName = stuNickName;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNickName() {
        return stuNickName;
    }

    public void setStuNickName(String stuNickName) {
        this.stuNickName = stuNickName;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }

    public StudentNode getPre() {
        return pre;
    }

    public void setPre(StudentNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "StudentNode{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", stuNickName='" + stuNickName + '\'' +
                '}';
    }
}
