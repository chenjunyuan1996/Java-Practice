/*
378. 有序矩阵中第K小的元素
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。

链接: https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        Queue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] cur = pq.poll();
            if (cur[2] < n - 1) {
                int x = cur[1], y = cur[2] + 1;
                pq.offer(new int[]{matrix[x][y], x, y});
            }
        }
        return pq.poll()[0];
    }
}
