package com.ncst1.trie;

import com.ncst1.utils.Asserts;

public class Main {

    static void test1() {
        Trie<Integer> trie = new Trie<>();
        trie.add("cat", 1);
        trie.add("dog", 2);
        trie.add("catalog", 3);
        trie.add("cast", 4);
        trie.add("小码哥", 5);
        Asserts.test(trie.size() == 5);
        Asserts.test(trie.startsWith("do"));
        Asserts.test(trie.startsWith("c"));
        Asserts.test(trie.startsWith("ca"));
        Asserts.test(trie.startsWith("cat"));
        Asserts.test(trie.startsWith("cata"));
        Asserts.test(!trie.startsWith("hehe"));
        Asserts.test(trie.get("小码哥") == 5);
        Asserts.test(trie.remove("cat") == 1);
        Asserts.test(trie.remove("catalog") == 3);
        Asserts.test(trie.remove("cast") == 4);
        Asserts.test(trie.size() == 2);
        Asserts.test(trie.startsWith("小"));
        Asserts.test(trie.startsWith("do"));
        Asserts.test(!trie.startsWith("c"));
    }

    static void test2() {
        Trie<Integer> trie = new Trie<>();
        trie.add("cat", 1);
        trie.add("dog", 2);
        trie.add("cast", 3);
        trie.add("add", 4);
        trie.add("doggy", 5);
        trie.add("does", 6);

    }

    public static void main(String[] args) {
        test2();
    }

}
