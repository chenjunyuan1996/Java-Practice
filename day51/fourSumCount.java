/*
454. 四数相加 II
给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum-ii
 */

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int a: A) {
            for (int b: B) {
                hashmap.put(-a-b, hashmap.getOrDefault(-a-b, 0) + 1);
            }
        }

        for (int c: C) {
            for (int d: D) {
                res += hashmap.getOrDefault(c+d, 0);
            }
        }
        
        return res;

    }
}
