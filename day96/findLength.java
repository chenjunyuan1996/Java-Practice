// dp
// class Solution {
//     public int findLength(int[] A, int[] B) {
//         int m = A.length, n = B.length;
//         int[][] dp = new int[m][n];
//         int res = 0;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (A[i] == B[j]) {
//                     dp[i][j] = (i > 0 && j > 0) ? dp[i - 1][j - 1] + 1 : 1;
//                     res = Math.max(res, dp[i][j]);
//                 }
//             }
//         }
//         return res;
//     }
// }

class Solution {
    int[] A;
    int[] B;
    public int findLength(int[] A, int[] B) {
        this.A = A;
        this.B = B;
        int m = A.length, n = B.length, res = 0;
        int length;
        for (int i = 0; i < m; i++) {
            length = Math.min(n, m - i);
            res = Math.max(res, slide(i, 0, length));
        } 
        for (int j = 0; j < n; j++) {
            length = Math.min(n - j, m);
            res = Math.max(res, slide(0, j, length));
        }
        return res;

    }

    private int slide(int a, int b, int length) {
        int res = 0, tmp = 0;
        for (int i = 0; i < length; i++) {
            if (this.A[a + i] == this.B[b + i]) {
                tmp++;
                res = Math.max(res, tmp);
            } else {
                tmp = 0;
            }
        }
        return res;

    }
}
