package com.edu.tree.huffmantree;

/**
 * @Date 2020/6/10 17:14
 * @Author by LiShiYan
 * @Description 霍夫曼树结点
 * 为了让Node 对象使用排序Collections集合排序，实现Comparable接口
 */
public class Node implements Comparable<Node> {
    /**
     * 数据
     */
    private Integer data;
    /**
     * 左结点
     */
    private Node left;
    /**
     * 右结点
     */
    private Node right;

    public Node(Integer data) {
        this.data = data;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        //输出当前结点
        System.out.println(this);
        //输出左结点
        if (this.left!=null){
            this.left.preOrder();
        }
        //输出右结点
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * 重写排序方法
     * @param o 对象中另一个对象
     * @return 升序排序
     */
    @Override
    public int compareTo(Node o) {
        // 表示从小到大排序
        // 表示从大到小排序: -(this.data-o.data)
        return this.data-o.data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
