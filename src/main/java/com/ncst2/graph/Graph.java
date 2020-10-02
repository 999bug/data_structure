package com.ncst2.graph;

/**
 * @Date 2020/10/1 16:08
 * @Author by LSY
 * @Description 图的数据结构
 * Vertex 顶点
 * edge 边
 */
public abstract class Graph<V, E> {

    /**
     * 边的大小
     * @return 边的大小
     */
    public abstract int edgesSize();

    /**
     * 顶点的大小
     * @return 顶点的大小
     */
    public abstract int verticesSize();

    /**
     * 添加顶点
     * @param v 顶点
     */
    public abstract void addVertex(V v);

    /**
     * 普通不带权重的添加边
     * @param from 从何处来
     * @param to 到何处去
     */
    public abstract void addEdge(V from ,V to);

    /**
     * 带有权重的添加边
     * @param from 从何处来
     * @param to 到何处去
     * @param weight 权重
     */
    public abstract  void addEdge(V from,V to,E weight);

    /**
     * 删除顶点
     * @param v 顶点
     */
    public abstract void removeVertex(V v);

    /**
     *  删除边
     * @param from 从哪里来
     * @param to 去哪里去
     */
    public abstract void removeEdge(V from,V to);

    /**
     * BFS 层序遍历
     * @param begin 起点
     */
    public abstract  void bfs(V begin);

    /**
     * DFS 深序遍历
     * @param begin 起点
     */
    public abstract  void dfs(V begin);

}
