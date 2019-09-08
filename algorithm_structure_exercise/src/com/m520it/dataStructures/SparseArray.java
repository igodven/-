package com.m520it.dataStructures;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class SparseArray {

    public SparseArray() throws FileNotFoundException {
    }

    public static void main(String[] args) {

        //构建一个11*11的棋盘
        /**
         * 0:表示没有棋子
         * 1:表示蓝子
         * 2:表示黑子
         */
        int[][] cheessAr1 = new int[11][11];
        //给二维数组的棋盘指定的位置赋值
        cheessAr1[1][2]=1;
        cheessAr1[2][3]=2;
        cheessAr1[5][6]=2;
        cheessAr1[4][7]=1;
        System.out.println("原始的数组");
        //将二维数组打印出来(棋盘的布局打印出来)
        for (int[] row : cheessAr1) {
            for (int value : row) {
                System.out.print(" "+value);
            }
            System.out.println();
        }

        //将二维数组,转换成稀疏数组
        //先计算二维数组有多少个数据不为零
        int sum=0;
        for (int i = 0; i < cheessAr1.length; i++) {
            for (int j = 0; j < cheessAr1[0].length; j++) {
                if (cheessAr1[i][j]!=0){
                    sum++;
                }
            }
        }

        System.out.println("将原始的数组转换成稀疏数组");
        //构建稀疏数组
        int[][] sparseArr1=new int[sum+1][3];
        sparseArr1[0][0]=cheessAr1.length;
        sparseArr1[0][1]=cheessAr1[0].length;
        sparseArr1[0][2]=sum;
        //设置一个变量用来记录每次存储增长的行数
        int sparesRow=0;
       //将原始的二维数组的棋盘包含的值,存储到稀疏数组中去
        for (int i = 0; i < cheessAr1.length; i++) {
            for (int j = 0; j < cheessAr1[0].length; j++) {
                if (cheessAr1[i][j]!=0){
                    sparesRow++;
                    sparseArr1[sparesRow][0]=i;
                    sparseArr1[sparesRow][1]=j;
                    sparseArr1[sparesRow][2]=cheessAr1[i][j];
                }
            }
        }
        for (int i = 0; i < sparseArr1.length; i++) {
            System.out.println(sparseArr1[i][0]+"  "+sparseArr1[i][1]+"  "+sparseArr1[i][2]);
        }

        System.out.println("将稀疏数组转换成原始的数组");
        //将稀疏数组转换成二维数组
        //读取稀疏数组第一行关于原始数组的行和列的信息,并根据行和列的信息,创建一个新的数组
        int[][] chessArr2=new int[sparseArr1[0][0]][sparseArr1[0][1]];

        //将值赋给原始数组的指定的位置
        for (int i = 1; i <=sparesRow; i++) {
                chessArr2[sparseArr1[i][0]][sparseArr1[i][1]]=sparseArr1[i][2];
        }
        for (int[] row : chessArr2) {
            for (int value : row) {
                System.out.print(" "+value);
            }
            System.out.println();
        }


        System.out.println("将稀疏数组的二维数组,保存到磁盘中");
        //将原始数组转换成稀疏数组后,存储到磁盘中去
        File file=new File("D://dataStructure//");
        //如果文件夹不存在的话,则创建一个目录
        if (!file.exists()){
            file.mkdir();
        }

        Map<Integer,int[]> map=new HashMap<>();
        for (int i = 0; i < sparseArr1.length; i++) {
            map.put(i,sparseArr1[i]);
        }
        Writer out= null;
        try {
            out = new FileWriter(new File("D://dataStructure//123.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bufferedWriter=new BufferedWriter(out);
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            String str = Arrays.toString(map.get(key));
            try {
                bufferedWriter.write(str,0,str.length());

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("从磁盘中读取稀疏数组的数据,并将其转换成原始的数组");
        //从磁盘中读取稀疏数组,然后转换成原始数组
        Reader reader= null;
        try {
            reader = new FileReader(new File("D://dataStructure//123.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader=new BufferedReader(reader);

        Stream<String> stream = bufferedReader.lines();
        Object[] objects = stream.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

    }

}
