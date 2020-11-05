package com.ncst2.greddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Date 2020/11/4 21:04
 * @Author by LSY
 * @Description 0 1 背包问题
 */
public class Knapsack {


    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();

        knapsack.select("价值优先", (Article a1, Article a2) -> a2.value - a1.value);
        knapsack.select("重量优先", (Article a1, Article a2) -> a1.weight - a2.weight);
        // select("重量优先", Comparator.comparingInt((Article a) -> a.weight));
        knapsack.select("密度优先", (Article a1, Article a2) -> Double.compare(a2.valueDensity, a1.valueDensity));
    }

    public void select(String title, Comparator<Article> cmp) {
        Article[] articles = new Article[]{
                new Article(35, 10), new Article(30, 40),
                new Article(60, 30), new Article(50, 50),
                new Article(40, 35), new Article(10, 40),
                new Article(25, 30)
        };
        Arrays.sort(articles, cmp);
        int capacity = 150, weight = 0, value = 0;
        List<Article> selectArticles = new ArrayList<>();

        for (int i = 0; i < articles.length && weight < capacity; i++) {
            int newWeight = weight + articles[i].weight;
            if (newWeight <= capacity) {
                weight = newWeight;
                value += articles[i].value;
                selectArticles.add(articles[i]);
            }
        }
        System.out.println("[" + title + "]");
        System.out.println("总价值：" + value);
        for (Article selectArticle : selectArticles) {
            System.out.println(selectArticle);
        }
        System.out.println("---------");
        //show(title, selectArticles,value);
    }

    private void show(String title, List<Article> selectArticles, int value) {
        System.out.println("[" + title + "]");
        System.out.println("总价值：" + value);
        for (Article selectArticle : selectArticles) {
            System.out.println(selectArticle);
        }
        System.out.println("---------");
    }

    static class Article {
        /**
         * 价值
         */
        int value;
        /**
         * 重量
         */
        int weight;
        /**
         * 价值密度
         */
        double valueDensity;

        public Article(int weight, int value) {
            this.value = value;
            this.weight = weight;
            valueDensity = value * 1.0 / weight;
        }

        @Override
        public String toString() {
            return "Article{" +
                    "value=" + value +
                    ", weight=" + weight +
                    ", valueDensity=" + valueDensity +
                    '}';
        }
    }
}
