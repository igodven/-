package com.m520it.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式:1+((2+5)*6)-9
 * 后缀表达式:1 2 5 + 6 * + 9 -
 * 扫描后缀表达式的计算分析:
 * *遇到数字直接入栈
 * *遇到运算符,取出栈中的两个数据,根据遇到的运算符,把两个数据进行计算
 * *计算得到结果后,在把结果压入栈中,然后再对后缀表达式进行后面的循环的迭代
 */
public class SuffixCalculationByStack {

    public static void main(String[] args) {

        //创建一个后缀表达式
        String suffixExpression = "1 2 5 + 6 * + 9 -";

        //创建一个操作后缀表达式的对象
        SuffixCalculation suffixCalculation = new SuffixCalculation();

        //将后缀表达式转化成list的集合
        List<String> list = suffixCalculation.changeToList(suffixExpression);

        int result = suffixCalculation.calculationMethod(list);
        System.out.println("计算后的结果:"+result);
    }
}

//构建一个类,用来扫描后缀表达式,并对后缀表达式进行分析的处理计算
class SuffixCalculation {

    //创建一个方法,具体的实现的方式
    public int calculationMethod(List<String> list) {
        int result;
        //创建一个栈,用来封装数字
        Stack<String> stack = new Stack<>();
        for (String str : list) {
            if (str.matches("\\d+")) {
                //如果匹配的字符串是数字,直接入栈
                stack.push(str);
            } else {
                //如果匹配的不是数字,则从栈中弹出两个数字进行运算
                String pop1 = stack.pop();
                String pop2 = stack.pop();
                if ("+".equals(str)) {
                    //计算结果,并将结果压入栈中
                    result = Integer.parseInt(pop1) + Integer.parseInt(pop2);
                    stack.push("" + result);
                } else if ("-".equals(str)) {
                    result = Integer.parseInt(pop2) - Integer.parseInt(pop1);
                    stack.push("" + result);
                } else if ("*".equals(str)) {
                    result = Integer.parseInt(pop1) * Integer.parseInt(pop2);
                    stack.push("" + result);
                } else if ("/".equals(str)) {
                    result = Integer.parseInt(pop2) / Integer.parseInt(pop1);
                    stack.push("" + result);
                }else{
                    System.out.println("没有匹配的运算符!");
                }
            }
        }
        return Integer.parseInt(stack.pop());

    }

    //创建一个方法,将字符串形式的后缀表达式,转化成list的集合
    public List<String> changeToList(String suffixExpression) {
        //将字符串根据空格进行拆分
        String[] strs = suffixExpression.split(" ");
        //创建一个list的集合,用来封装strs数组的元素
        List<String> list = new ArrayList<>();
        for (String str : strs) {
            list.add(str);
        }
        return list;
    }
}
