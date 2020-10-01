package com.ncst2.graph;

import java.util.*;

/**
 * @Date 2020/10/1 16:21
 * @Author by LSY
 * @Description 邻接表实现图
 */
public class ListGraph<V, E> extends Graph<V, E> {

    private Map<V, Vertex<V, E>> vertices = new HashMap<>();
    private Set<Edge<V, E>> edges = new HashSet<>();

    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) {
            return;
        }
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    @Override
    public void addEdge(V from, V to, E weight) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            //重新赋值
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            //重新赋值
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight;

        //采用删除之前存在的 Edge 在添加新的Edge 的思想
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            //删除 Edge集合的对象
            edges.remove(edge);
        }

        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);
        if (vertex==null){
            return;
        }
        for (Iterator<Edge<V, E>> it = vertex.outEdges.iterator(); it.hasNext(); ) {
            Edge<V, E> edge = it.next();
            //删除 去的那个结点的入边
            edge.to.inEdges.remove(edge);
            // 将当前遍历到的元素edge从集合vertex.outEdges中删掉
            it.remove();
            //删除 edges set 集合中的 出方向的边
            edges.remove(edge);
        }

        for (Iterator<Edge<V, E>> it = vertex.inEdges.iterator(); it.hasNext(); ) {
            Edge<V, E> edge = it.next();
            edge.from.outEdges.remove(edge);
            // 将当前遍历到的元素edge从集合vertex.inEdges中删掉
            it.remove();
            //删除 edges set 集合中的 入 方向的边
            edges.remove(edge);
        }
    }

    @Override
    public void removeEdge(V from,V to) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex==null){
            return;
        }

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex==null){
            return;
        }
        //新创建一个 Edge<V,E> 对象，如果 这个 edge对象 和从集合中获得的 fromVertex 相同则删除
        //使用 equal 来比较是否相同，并不是比较内存地址
        //如果删除成功则 说明新创建的对象，原来存在
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if (fromVertex.outEdges.remove(edge)){
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }

    }

    public void print() {
        System.out.println("[顶点]-------------------");
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            System.out.println(v);
            System.out.println("out-----------");
            System.out.println(vertex.outEdges);
            System.out.println("in-----------");
            System.out.println(vertex.inEdges);
        });

        System.out.println("[边]-------------------");
        edges.forEach(System.out::println);
        /*edges.forEach((Edge<V, E> edge) -> {
            System.out.println(edge);
        });*/
    }

    private static class Edge<V, E> {
        Vertex<V, E> from;
        Vertex<V, E> to;
        E weight;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object obj) {
            Edge<V, E> edge = (Edge<V, E>) obj;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    private static class Vertex<V, E> {
        V value;
        Set<Edge<V, E>> inEdges = new HashSet<>();
        Set<Edge<V, E>> outEdges = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.equals(value, ((Vertex<V, E>) obj).value);

        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }

        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
        }

    }
}
