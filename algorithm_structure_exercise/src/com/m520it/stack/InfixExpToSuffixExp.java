package com.m520it.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//创建一个类,用来封装将中缀表达式,转化为后缀表达式
public class InfixExpToSuffixExp {

    /**
     *  中缀表达式:1+((2+5)*(6-4))-9
     *  后缀表达式:1 2 5 + 6 4 - * + 9 -
     * @param infixExpression 中缀表达式
     * @return
     * 实现的原理分析:
     *     前提:创建一个栈和一个list的集合,(为什么不创建两个栈,因为一个栈没有出栈的操作,创建没有意义,而且后续不好操作)
     *       1.对中缀表达式,进行循环扫描迭代
     *           1.1如果是数字,直接放到list的集合中去
     *           1.2如果是运算符,先判断栈中是否有有元素,如果没有元素,则直接放入栈中
     *              1.2.1如果栈中有元素,先用扫描到的元素和栈顶的元素进行优先级的比较
     *              1.2.2如果栈中的优先级大于等于,扫描到的元素的优先级,则栈顶的元素出栈,并且将其放入list的集合中,扫描到的元素入栈
     *              1.2.3如果栈中的优先级小于扫描到的元素的优先级,则直接入栈
     *           1.3如果是(,直接入栈,如果遇见),则将栈顶的元素出栈,将其加入到list的集合中,并且将其对称的(出栈
     *
     *
     */
    public List<String> infixToSufixExpression(String infixExpression){
        //将中缀表达式转化成list的集合
        List<String> infixToList = this.infixToList(infixExpression);

        //创建一个集合,用来封装后缀表达式的结果
        List<String> sufixExe=new ArrayList<>();

        //创建一个栈,用来对运算符的出栈和入栈的操作
        Stack<String> stack=new Stack<>();

        //进行操作,将中缀表达式,转化成后缀表达式
        for (String infixExe : infixToList) {
            if (infixExe.matches("\\d+")){
                //如果匹配到数字,直接加入到list的集合中
                sufixExe.add(infixExe);
            }else if(infixExe.equals("(")){
                //如果匹配到(,则直接入栈
                stack.push(infixExe);
            }else if (infixExe.equals(")")){
                //如果匹配到),则将栈顶的元素出栈,加入到list的集合中,并且将对应的(出栈
                String pop = stack.pop();
                sufixExe.add(pop);
                stack.pop();
            }else{
                //对符号的优先级进行比较
                if(stack.size()==0||this.comparePriority(infixExe)>this.comparePriority(stack.peek())){
                    stack.push(infixExe);
                }else{
                    sufixExe.add(stack.pop());
                    stack.push(infixExe);
                }
            }

        }
        //将栈中剩下的元素,一次弹如list的集合中
        while(stack.size()!=0){
            sufixExe.add(stack.pop());
        }
        return  sufixExe;
    }
    //创建一个方法,将中缀表达式,封装到list的集合中,方便后续的操作
    public List<String> infixToList(String infixExpression){
        int index=0;
        //创建一个集合,用来封装迭代出的元素
        List<String> list=new ArrayList<>();
        while(true){
            String substring = infixExpression.substring(index, index + 1);
            list.add(substring);

            index=index+1;
            if (index>=infixExpression.length()){
                break;
            }
        }
        return  list;
    }

    //创建一个方法,对符号的优先级,进行比较
    public int comparePriority(String operator){
        switch (operator){
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            default:
                return 0;
        }

    }
}
