package com.edu.graph;

/**
 * @Date 2020/6/3 18:01
 * @Author by hp
 * @Description TODO
 */
public class Test {


    public void test() {
        //图对象
        Graph graph = new Graph(8);

        //添加节点
        //String[] vertexS = {"A", "B", "C", "D", "E"};
        String[] vertexS  = {"1", "2", "3", "4", "5", "6", "7", "8"};

        for (String vertex : vertexS) {
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
		/*graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);*/

        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);


        //显示一把邻结矩阵
        graph.showGraph();

        //输出深度优先遍历
        System.out.println("深度优先搜索");
        graph.dfs();
        System.out.println();
        System.out.println(" ********************************");
        //输出广度优先遍历
        System.out.println("广度优先搜索");
        graph.bfs();


    }
}

