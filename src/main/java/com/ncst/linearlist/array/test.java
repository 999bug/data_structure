package com.ncst.linearlist.array;

/**
 * @Date 2020/8/20 9:06
 * @Author by LiShiYan
 * @Descaption
 */
public class test {

    public static void main(String[] args) {
       /* MyArrayList<Integer> list = new MyArrayList<>(5);
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }
        System.out.println(list.toString());*/
       // boolean contains = list.contains(8);
       // System.out.println("contains = " + contains);

       // int i = list.indexOf(4);
       // System.out.println("i = " + i);

        //int index = 5;
        // int remove = list.remove(index);
       // System.out.println("remove = " + remove);

        MyArrayList<Person> persons=new MyArrayList<>();
		persons.add(new Person(10, "Jack"));
		persons.add(new Person(15, "Rose"));
		//persons.add(null);

		persons.add(new Person(12, "James"));

		persons.remove(0);
        System.out.println(persons.toString());

    }
}
