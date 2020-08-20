package com.edu.testTree;

import org.junit.Test;

import java.io.*;


public class text {
    public static void print(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }


    @Test
    public void test3(){
        Integer i=120;
        Integer b=120;

        Integer c=127;
        Integer d=127;
    }
    @Test
    public void test1() {

        int arr2[][]=new int[11][3];
        File file = new File("d:\\c.txt");
        //从磁盘中恢复稀疏数组
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String line;  //一行数据
            int row = 0;
            //逐行读取，并将每个数组放入到数组中
            while ((line = in.readLine()) != null) {
                String[] t1emp = line.split("\t");
                for (int j = 0; j < t1emp.length; j++) {
                    arr2[row][j] = Integer.parseInt(t1emp[j]);

                }
                row++;
            }
            int[] getrow = getrow(arr2);
            int row1=getrow[0];
            int col=getrow[1];
            int val=getrow[2];
           int arr3[][]=new int[row1][3];


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        print(arr2);
    }
    public static int[] getrow(int[][] a){
        int cc=0;
        int[] b=new int[4];
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a.length ; j++) {

                b[cc]=a[i][j];cc++;
            }
        }
        return b;

    }
    @Test
    public  void  a(){
        int arr2[][]=new int[11][3];
        File file = new File("d:\\c.txt");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String line;  //一行数据
            int row = 0;
            //逐行读取，并将每个数组放入到数组中
            while ((line = in.readLine()) != null) {
                String[] t1emp = line.split("\t");
                for (int j = 0; j < t1emp.length; j++) {
                    arr2[row][j] = Integer.parseInt(t1emp[j]);

                }
                row++;
            }
            int[] getrow = getrow(arr2);
            int row1=getrow[0];
            int col=getrow[1];
            int val=getrow[2];
            System.out.println("row1"+row1);
            int arr3[][]=new int[row1][3];
            in = new BufferedReader(new FileReader(file));
            String line1;  //一行数据
            int row11 = 0;
            //逐行读取，并将每个数组放入到数组中
            while ((line1 = in.readLine()) != null) {
                String[] t1emp = line1.split("\t");
                for (int j = 0; j < t1emp.length; j++) {
                    arr3[row][j] = Integer.parseInt(t1emp[j]);

                }
                row11++;
            }
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
