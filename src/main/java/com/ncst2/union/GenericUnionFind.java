package com.ncst2.union;

import com.ncst1.map.HashMap;
import com.ncst1.map.Map;

import java.util.Objects;

/**
 * @Date 2020/9/29 16:55
 * @Author by LSY
 * @Description 通用并查集
 */
public class GenericUnionFind<V> {
    private Map<V, Node<V>> nodes = new HashMap<>();

    /**
     * 初始化 每个容器
     */
    public void makeSet(V v) {
        if (nodes.containsKey(v)) {
            return;
        }
        nodes.put(v, new Node<>(v));
    }

    /**
     * 找到根节点
     */
    private Node<V> findNode(V v) {
        Node<V> node = nodes.get(v);
        if (node == null) {
            return null;
        }
        //基于Path Having
        while (!Objects.equals(node.value, node.parent.value)) {
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }

    /**
     * 找到根节点的值
     */
    public V find(V v) {
        Node<V> node = findNode(v);
        return node == null ? null : node.value;
    }

    public void union(V v1, V v2) {
        Node<V> p1 = findNode(v1);
        Node<V> p2 = findNode(v2);
        if (p1 == null || p2 == null) {
            return;
        }
        //如果 连个结点的值，相等则说明是同一个集合 直接返回
        if (Objects.equals(p1.value, p2.value)) {
            return;
        }
        if (p1.rank < p2.rank) {
            p1.parent = p2;
        } else if (p1.rank > p2.rank) {
            p2.parent = p1;
        } else {
            p1.parent = p2;
            p2.rank += 1;
        }

    }

    public boolean isSame(V v1, V v2) {
        return Objects.equals(find(v1), find(v2));
    }

    private static class Node<V> {
        /**
         * V 的值
         */
        V value;
        /**
         * NOde 的父节点初始为指向自己
         */
        Node<V> parent = this;
        /**
         * 等级 默认为 1
         */
        int rank = 1;

        Node(V value) {
            this.value = value;
        }
    }
}
