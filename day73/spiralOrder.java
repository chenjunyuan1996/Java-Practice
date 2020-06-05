/*
面试题29. 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

链接: https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
*/

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                res[index] = matrix[top][j];
                index++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[index] = matrix[i][right];
                index++;
            }

            if (left == right || top == bottom) break;
            for (int j = right - 1; j > left; j--) {
                res[index] = matrix[bottom][j];
                index++;
            }
            for (int i = bottom; i > top; i--) {
                res[index] = matrix[i][left];
                index++; 
            }
            
            left++; right--; top++; bottom--;
        }
        return res;

    }
}
