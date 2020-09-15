package com.ncst.trie;


import java.util.HashMap;

/**
 * @Date 2020/9/15 21:14
 * @Author by LiShiYan
 * @Descaption 字典树、前缀树、单词查找树
 */
public class Trie<V> {
    private int size;
    private Node<V> root;

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(String key) {
        Node<V> node = node(key);
        return node != null && node.word;
    }

    public V get(String key) {
        Node<V> node = node(key);
        return node != null && node.word ? node.value : null;
    }

    public V add(String key, V value) {
        keyCheck(key);

        //创建根节点，根节点不存储值
        if (root == null) {
            root = new Node<>(null);
        }

        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c = key.charAt(i);
            boolean emptyChildren = node.children == null;
            Node<V> childNode = emptyChildren ? null : node.children.get(c);

            if (childNode == null) {
                //新增元素，并且赋值
                childNode = new Node<>(node);
                childNode.character = c;

                //如果新结点为空 则创建HashMap
                node.children = emptyChildren ? new HashMap<>() : node.children;

                /*将新添加的结点放到map中  第一次添加时，node为根节点
                key：为字符 c
                value： childNode
                如果childNode 为null 则为空 */
                node.children.put(c, childNode);
            }

            //将node 指针 移动到 childNode ，使childNode 成为下一个新添加的结点父节点
            node = childNode;
        }

        //已经存在这个单词
        if (node.word) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        //新增一个单词
        node.word = true;
        node.value = value;
        size++;

        return null;
    }

    public V remove(String key) {
        //找到最后一个结点
        Node<V> node = node(key);

        //如果不是单词结尾，不用做任何处理
        if (node == null || !node.word) {
            return null;
        }

        size--;
        V oldValue = node.value;

        //如果还有子节点
        if (node.children != null && !node.children.isEmpty()) {
            node.word = false;
            node.value = null;

            return oldValue;
        }

        //如果没有子节点
        Node<V> parent = null;
        while ((parent = node.parent) != null) {
            parent.children.remove(node.character);
            if (parent.word || !parent.children.isEmpty()) {
                break;
            }
            node = parent;
        }
        return oldValue;
    }

    public boolean startsWith(String prefix) {
        return node(prefix) != null;
    }

    /**
     * @param key
     * @return 返回最后一个结点
     */
    private Node<V> node(String key) {
        keyCheck(key);

        Node<V> node = this.root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            if (node == null || node.children == null || node.children.isEmpty()) {
                return null;
            }
            char c = key.charAt(i);
            node = node.children.get(c);
        }

        //返回最后一个结点
        return node;
    }

    private void keyCheck(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("key must not be empty");
        }
    }

    private static class Node<V> {
        Node<V> parent;
        HashMap<Character, Node<V>> children;
        Character character;
        V value;
        //是否为单词的结尾（是否为一个完整的单词）
        boolean word;

        public Node(Node<V> parent) {
            this.parent = parent;
        }
    }
}
