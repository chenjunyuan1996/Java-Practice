/*
547. 朋友圈
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

链接: https://leetcode-cn.com/problems/friend-circles/
*/

class Solution {
    public int findCircleNum(int[][] M) {
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                M[i][i] = 0;
                res++;

                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int m = queue.poll();
                    for (int n = 0; n < M[m].length; n++) {
                        if (M[m][n] == 1) {
                            M[m][n] = 0; M[n][m] = 0; M[n][n] = 0;
                            queue.offer(n);
                        }
                    }
                }
            }
        }
        return res;

    }
}
