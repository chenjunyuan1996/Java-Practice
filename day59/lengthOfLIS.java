/*
300. 最长上升子序列
给定一个无序的整数数组，找到其中最长上升子序列的长度。

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        int res = 0;
        
        for (int num : nums) {
            int l = 0, r = res;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (LIS[mid] >= num) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            LIS[l] = num;
            if (r == res) res++;
        }
        return res;

    }
}


// class Solution {
//     public int lengthOfLIS(int[] nums) {

//         int[] dp = new int[nums.length];
//         int res = 0;
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[i] > nums[j]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             res = Math.max(res, dp[i] + 1);
//         }
//         return res;

//     }
// }
