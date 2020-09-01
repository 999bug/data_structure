package com.ncst.set;

import com.ncst.set.file.FileInfo;
import com.ncst.set.file.Files;
import com.ncst.utils.Task;
import com.ncst.utils.Times;

/**
 * @Date 2020/9/1 9:57
 * @Author by LiShiYan
 * @Descaption
 */
public class Test {
    public static void main(String[] args) {
        test2();
    }

    static void testSet(ISet<String> set, String[] words) {
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            set.contains(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            set.remove(words[i]);
        }
    }

    static void test2() {
        FileInfo fileInfo = Files.read("E:\\test\\src",
                new String[]{"java"});

        System.out.println("文件数量：" + fileInfo.getFiles());
        System.out.println("代码行数：" + fileInfo.getLines());
        String[] words = fileInfo.words();
        System.out.println("单词数量：" + words.length);
        Times.test("TreeSet", new Task() {
            @Override
            public void execute() {
                testSet(new MyTreeSet<>(), words);
            }
        });
        Times.test("ListSet", new Task() {
            @Override
            public void execute() {
                testSet(new MySet<>(), words);
            }
        });


    }

    static void testSet() {
        MySet<Integer> listSet = new MySet<>();
        listSet.add(10);
        listSet.add(11);
        listSet.add(11);
        listSet.add(12);
        listSet.add(10);
        listSet.traversal(new ISet.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }

    static void testTreeSet() {
        MyTreeSet<Integer> listSet = new MyTreeSet<>();
        listSet.add(10);
        listSet.add(11);
        listSet.add(11);
        listSet.add(12);
        listSet.add(10);
        listSet.traversal(new ISet.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
