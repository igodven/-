package com.m520it.stack;

import java.util.List;

public class InfixToSufixTest {
    public static void main(String[] args) {
        InfixExpToSuffixExp infixExpToSuffixExp=new InfixExpToSuffixExp();
        String infixExe="1+((2+5)*(6-4))-9";
        List<String> list = infixExpToSuffixExp.infixToSufixExpression(infixExe);
        System.out.println(list);
        //测试结果:
        SuffixCalculation suffixCalculation=new SuffixCalculation();
        int result = suffixCalculation.calculationMethod(list);
        System.out.println("测试的结果是:"+result);
    }
}
