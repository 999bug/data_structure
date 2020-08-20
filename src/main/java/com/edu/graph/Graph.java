package com.edu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Date 2020/6/3 17:27
 * @Author by hp
 * @Description 图
 */
public class Graph {
    /**
     * 存储顶点集合
     */
    private ArrayList<String> vertexList;
    /**
     * 存储图对应的邻接矩阵
     */
    private int[][] edges;
    /**
     * 表示边的数目
     */
    private int numOfEdges;
    /**
     * 记录某个节点是否被访问
     */
    private boolean[] isVisited;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;

    }


    /**
     * 深度优先算法
     *
     * @param isVisited 节点数组是否被访问
     * @param i         节点
     */
    private void dfs(boolean[] isVisited, int i) {
        //输出访问的第一个节点
        System.out.print(getValueByIndex(i) + "->");
        //将节点设置成已访问
        isVisited[i] = true;
        //查找节点i的第一个邻接节点
        int w = getFirstNeighbor(i);
        //如果节点存在进行循环
        while (w != -1) {
            //节点没有被访问
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //节点已经被访问
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 对dfs进行重载，遍历我们所有的节点，进行dfs
     */
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 对一个节点进行广度优先遍历
     *
     * @param isVisited 访问节点数组是否被访问
     * @param i         节点
     */
    private void bfs(boolean[] isVisited, int i) {
        //表示队列的头结点对应的下标
        int u;
        //邻接节点w
        int w;
        //队列，记录节点访问的顺序
        LinkedList<Integer> queue = new LinkedList<>();

        //1.访问节点,输出节点信息
        System.out.print(getValueByIndex(i) + "=>");
        //标记已访问
        isVisited[i] = true;
        //2.将节点加入队列
        queue.addLast(i);

        //3.当队列非空时继续执行
        while (!queue.isEmpty()) {
            //4.取出队列的头结点下标
            u = queue.removeFirst();
            //5.得到第一个邻接节点的下标w
            w = getFirstNeighbor(u);

            //存在下一个邻接节点
            while (w != -1) {
                //没有被访问
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    //6.1标记已访问
                    isVisited[w] = true;
                    //6.2入队
                    queue.addLast(w);
                }
                //6.3访问过,以 u 为前驱点，找w后面的下一个邻接节点
                w = getNextNeighbor(u, w);
            }
        }
    }

    /**
     * 遍历所有节点进行广度优先搜索
     */
    public void bfs(){
        isVisited=new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }


    /**
     * 得到第一个邻接节点的下标
     *
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标获取下一个邻接节点
     *
     * @param v1 节点v1
     * @param v2 节点 v2
     * @return 下一个邻接节点
     */
    public int getNextNeighbor(int v1, int v2) {
        //v2下标从0开始，所以要 +1
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return 边的数目
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * @return 节点的个数
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 显示图对应的矩阵
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    /**
     * 返回节点i(下标）对应的数据 0->"A" 1->"B" 2->"C"
     *
     * @param i i(下标）
     * @return 对应的数据
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * @param v1 节点v1的下标
     * @param v2 节点v2的下标
     * @return 返回v1和v2的权值
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 插入节点
     *
     * @param vertex 节点
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     v1 表示点的下标即使第几个顶点  "A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight 权重
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

}
