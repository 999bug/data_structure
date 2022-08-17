package com.offer.arrayorpoint;

import com.ncst2.dynamic.Lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Lisy
 * @Date: 2022/08/15/9:28
 * @Description: 顺时针打印矩阵(N * N)，顺时针打印二维数组
 */
public class PrintMatrixByClockwise {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 11},
                {4, 5, 6, 12},
                {7, 8, 9, 13}
//                {14, 15, 16, 17}
        };
        int[] ints = spiralOrder(array);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        // 返回数组下标
        int  index = 0;
        // 分别定义数组的4个边界值，左边界、上边界、右边界，下边界
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            // 边界值判断条件：上下执行完则判断左右，左右执行完则判断上下
            // 左到右执行则判断 ++top 是否大于 bottom
            // 上到下执行则判断 left  是否大于 --right
            // 右到左执行则判断 top 是否大于 --bottom
            // 下到上执行则判断 ++left 是否大于 right
            // left to right.
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            // top to bottom.
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (left > --right) {
                break;
            }
            // right to left.
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (top > --bottom) {
                break;
            }
            // bottom to top.
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }


    /**
     * 残血版，只能支持 N*N 版本的矩阵
     */
    private static List<Integer> spiralOrderDiscard(int[][] matrix) {
        if (Objects.isNull(matrix)) {
            return null;
        }
        int column = matrix[0].length - 1;
        int row = matrix.length - 1;
        int start = 0;
        List<Integer> result = new ArrayList<>();

        // 要想生活过的去，列坐标和行坐标至少要大于起始值的2倍，
        while (column > start << 1 && row > start << 1) {
            printMatrixInCycle(matrix, row, column, start, result);
            start++;
        }
        return result;
    }

    private static void printMatrixInCycle(int[][] arrays, int row, int column, int start, List<Integer> result) {
        // 未打印 列 坐标最后一位
        int endX = column - start;

        // 未打印 行 坐标最后一位
        int endY = row - start;

        // left-->right
        for (int i = start; i <= endX; i++) {
            result.add(arrays[start][i]);
        }

        // right-->bottom
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(arrays[i][endY]);
            }
        }

        // right-->left
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                result.add(arrays[endY][i]);
            }
        }

        // left-->top
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                result.add(arrays[i][start]);
            }
        }
    }
}
