package com.edu.xishuArray;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class sparseArray {
    public static void main(String[] args) throws IOException {
        //创建一个原始的二维数组11*11
        //0表示没有棋子，1表示黑子，2表示蓝子
        int chessArry1[][] = new int[11][11];
        chessArry1[1][2] = 1;
        chessArry1[2][3] = 2;
        chessArry1[6][5] = 2;
        chessArry1[7][7] = 1;
        chessArry1[4][6] = 1;
        chessArry1[7][3] = 1;
        //输出原始的二维数组
        System.out.println("原始二维数组");
        print(chessArry1);

        //将二维数组转换为稀疏数组
        //1、先遍历二维数组得到非0的个数
        int sum = getsum(chessArry1);

        //创建sparseArry
        int sparseArray[][] = new int[sum + 1][3];
        //给sparsrry赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int temp = 1;
        for (int a = 0; a < chessArry1.length; a++) {
            for (int i = 0; i < chessArry1.length; i++) {
                if (chessArry1[a][i] != 0) {
                    sparseArray[temp][0] = a;
                    sparseArray[temp][1] = i;
                    sparseArray[temp++][2] = chessArry1[a][i];
                }
            }
        }

        //将稀疏数组存储到磁盘中
        File file = new File("d:\\c.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            for (int[] ints : sparseArray) {
                for (int anInt : ints) {
                    fw.write(anInt + "\t");
                }
                fw.write("\r\n");
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("稀疏数组：");
        print(sparseArray);
        //获取稀疏数组的行数
        int i1 = getsumIo(file);
        int arr2[][] = new int[i1+1][3];
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
                    arr2[row][j]=(Integer.parseInt(t1emp[j]));
                }
                row++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("****************");
        System.out.println("磁盘写入稀疏数组:");
        print(arr2);
        System.out.println("**********************");

        //将稀疏数组恢复为原始数组
        //创建新数组
        int chessArry2[][] = new int[arr2[0][0]][arr2[0][1]];
        for (int i = 1; i < arr2.length; i++) {
            chessArry2[arr2[i][0]][arr2[i][1]] = arr2[i][2];
        }
        //输出稀疏数组转换的新数组
        print(chessArry2);
    }

    /**
     * 输出二维数组
     *
     * @param a
     */
    public static void print(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }


    /**
     * 得到sum值
     *
     * @param a
     * @return
     */
    public static int getsum(int[][] a) {
        int sum = 0;
        for (int[] ints : a) {
            for (int anInt : ints) {
                if (anInt != 0) sum++;
            }
        }
        return sum;
    }

    /**
     * 获取磁盘文件稀疏数组的数组行数
     * @param file
     * @return
     */
    public static int getsumIo(File file ){
        ArrayList<Integer> list=new ArrayList<>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String line;  //一行数据
            int row = 0;
            //逐行读取，并将每个数组放入到数组中
            while ((line = in.readLine()) != null) {
                String[] t1emp = line.split("\t");
                for (int j = 0; j < t1emp.length; j++) {
                    list.add(Integer.parseInt(t1emp[j]));
                }
                row++;
            }
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
        return  list.get(2);
    }

}
