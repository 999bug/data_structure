package com.ncst.heap;


import com.ncst.heap.printer.BinaryTrees;

/**
 * @Date 2020/9/12 21:50
 * @Author by LiShiYan
 * @Descaption
 */
public class Test {
    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(68);
        heap.add(72);
        heap.add(43);
        heap.add(50);
        heap.add(38);
        heap.add(10);
        heap.add(90);
        heap.add(65);
        BinaryTrees.println(heap);
         heap.remove();
         BinaryTrees.println(heap);

      //  System.out.println(heap.replace(70));
       // BinaryTrees.println(heap);
    }
}
