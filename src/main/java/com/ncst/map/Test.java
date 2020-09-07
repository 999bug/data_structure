package com.ncst.map;

/**
 * @Date 2020/9/1 15:28
 * @Author by LiShiYan
 * @Descaption
 */
public class Test {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("jack",1);
        map.put("rose",2);
        map.put("rose",2);
        System.out.println(map.size());
    }
}
