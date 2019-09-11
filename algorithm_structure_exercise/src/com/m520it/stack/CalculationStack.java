package com.m520it.stack;

/**
 * 用栈的方式,用栈的方式实现综合计算器
 * 前提:输入的计算表达式符合正常的数学公式
 * 创建一个字符串的索引指向计算表达式,用来迭代数值和符号表达式
 * 分析:
 * 1.创建两个栈,一个用来封装计算的数值,一个用来封装计算的符号
 * 2.如果发现只有一个数字,直接入数栈
 * 3.如果发现扫描到的是符号,就分如下的情况
 * 3.1:如果符号栈为空,则符号直接入栈
 * 3.2:如果符号栈不为空,则判断符号的优先级,如果新指向的符号的优先级小于或等于栈中存在的符号,
 * 则取出数值栈中的数值,和栈中已经存在的符号,然后将计算后的数值加入到数值栈中,将新指向的符号入栈
 * 3.3:如果符号不为空,则判断符号的优先级,如果新指向的符号的优先级大于栈中存在的符号,则符号直接入栈
 * 4.当表达式扫描完毕后,就顺讯的从数值栈中取出数字,和从符号栈中取出符号,进行计算,并且将计算后的结果入数值栈
 * 5,知道计算过后:数值栈中只有一个数字,然后取出结果集
 */
public class CalculationStack {

    public static void main(String[] args) {

        //创建一个计算的表达式
        String expression = "3+2*6-9+8-7";
        //创建两个栈
        CreateStack numStack = new CreateStack(10);
        CreateStack priStack = new CreateStack(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        char c = ' ';
        //将表达式进行迭代,将他们压入栈中
        while (true) {
            c = expression.substring(index, index + 1).charAt(0);
            //判断迭代的字符是否为运算符
            if (priStack.judgeCharacter(c)) {
                //如果迭代的字符是运算符,则需进行如下的操作
                //1.判断字符栈是否为空
                if (priStack.top == -1) {
                    //如果为空,符号直接入栈
                    priStack.addData(c);
                } else {
                    //如果运算符栈不为空,则需要判断运算符的优先级
                    if (priStack.judgePriority(c) <= priStack.judgePriority((char) priStack.peek())) {
                        //如果优先级小于等于栈中的优先级,则把数值栈中的数字pop出来,进行计算,在压入栈中
                        num1 = numStack.getData();
                        num2 = numStack.getData();
                        res = numStack.result(num1, num2, (char) priStack.getData());
                        //将得到的结果压入栈中
                        numStack.addData(res);
                        //将新的运算符压入栈中
                        priStack.addData(c);
                    } else {
                        //优先级大于栈中字符的优先级,则直接压入栈中
                        priStack.addData(c);
                    }
                }

            } else {
                //如果迭代的字符不是运算符,则直接加入数值栈中
                numStack.addData(c-48);

            }
            index = index + 1;
            //如果索引指向最后
            if (index == expression.length()) {
                //跳出循环
                break;
            }
        }
        while (true){
            //如果运算符的栈中不为空,则说明数值栈中不只一个数值
            if (priStack.top!=-1){
                /**
                 * 如果运算符的最后一个等于加号,第一个入栈的字符等于减号,就会计算的问题
                 *     *因为这种方法用的是从后往前的计算的方式,而同级的运算符应该是从前往后
                 */
                //if (priStack.peek()!='+'&&priStack.peek()!='-'||priStack.top==0) {
                    //如果优先级小于等于栈中的优先级,则把数值栈中的数字pop出来,进行计算,在压入栈中
                    num1 = numStack.getData();
                    num2 = numStack.getData();
                    res = numStack.result(num1, num2, (char) priStack.getData());
                    //将得到的结果压入栈中
                    numStack.addData(res);
               /* }else{

                }*/
            }else{
                break;
            }
        }
        res=numStack.getData();
        System.out.println(expression+"="+res);

    }
}

//定义一个栈的类,用来创建栈
class CreateStack {

    private int maxSize;  //数组的最大存储的容量
     int[] stack;  //创建一个数组,用来封装数据,模拟栈
    int top = -1;      //表示栈顶,添加一个数据,top+1,弹出一个数据:top-1

    //创建一个构造方法,用来初始化栈的信息

    public CreateStack(int maxSize) {
        this.maxSize = maxSize;
        //初始化数组的最大的存储容量
        stack = new int[maxSize];
    }

    //创建一个方法,用来判断栈是否满了
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //创建一个方法,判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //创建一个方法,向数组中添加数据
    public void addData(int data) {
        if (isFull()) {
            System.out.println("栈内的数据已满,栈溢出");
            return;
        }
        top++;
        stack[top] = data;
    }

    //创建一个方法,用来弹出数据
    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("栈中没有数据,不能输出数据");
        }
        int data = stack[top];
        top--;
        return data;
    }

    //创建一个方法,用来迭代出栈中的数据
    public void getAllData() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }


    //创建一个方法,用来判断扫描表达式是数值还是符号
    public boolean judgeCharacter(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    //创建一个方法,用来显示栈顶的数据
    public int peek() {
        return stack[top];
    }

    //创建一个方法,用来确定符号的优先级
    public int judgePriority(char c) {

        if (c == '*' || c == '/') {
            return 1;
        } else if (c == '-' || c == '+') {
            return 0;
        } else {
            return -1;
        }
    }

    //对数值栈中的数字进行计算
    public int result(int num1, int num2, char c) {
        if (c == '-') {
            return num2 - num1; //注意顺序,因为num1是最先弹出来的,但是表达式是第二个
        } else if (c == '*') {
            return num1 * num2;
        } else if (c == '/') {
            return num1 / num2;
        } else if (c == '+') {
            return num1 + num2;
        } else {
            throw new RuntimeException("此运算符不符合规定");
        }
    }
}