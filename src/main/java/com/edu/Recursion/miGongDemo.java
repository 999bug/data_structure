package com.edu.Recursion;

public class miGongDemo {

    /**
     * 创建迷宫地图
     *
     * @return
     */
    public static int[][] creatMap() {
        //1代表墙体
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        return map;
    }

    public static void show(int[][] map) {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯

    /**
     * @param map 迷宫地图
     * @param i   起始的横坐标
     * @param j   起始的纵坐标
     * @return 如果找到通路，就返回true, 否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {

        if (map[6][5] == 2) {//则表示找到终点
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前这个点没有走过
                //按照策略 下--> 右--> 上-->左 走
                map[i][j] = 2;//假定可以走通

                if (setWay(map, i + 1, j))//向下走
                    return true;
                else if (setWay(map, i, j + 1))//向右走
                    return true;
                else if (setWay(map, i - 1, j))//向上走
                    return true;
                else if (setWay(map, i, j - 1))//向左走
                    return true;
                else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else return false;//如果map[i][j]!=0,可能是1，2，3


        }

    }
    public static void migong(int[][]map,int i,int j){

    }

    public static void main(String[] args) {
        int[][] map = creatMap();
        System.out.println("原来的地图");
        show(map);
        System.out.println("走完迷宫后的地图");
        setWay(map, 1, 1);
        show(map);
    }
}
