/*
209. 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。

链接: https://leetcode-cn.com/problems/minimum-size-subarray-sum/
*/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) return 0;

        int n = nums.length, res = n + 1;
        int l = 0, r = 0;
        int sum = 0;
        while (r < n) {
            sum += nums[r];
            while (sum >= s) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l += 1;
            }
            r += 1;
        }
        return res == n + 1 ? 0 : res;

    }
}


// 暴力法
// class Solution {
//     public int minSubArrayLen(int s, int[] nums) {
//         if (nums == null) return 0;

//         int n = nums.length;
//         int res = n + 1;
//         for (int i = 0; i < n; i++) {
//             int sum = 0;
//             for (int j = i; j < n; j++) {
//                 sum += nums[j];
//                 if (sum >= s) {
//                     res = Math.min(res, j - i + 1);
//                     break;
//                 }
//             }
//         }
//         return res == n + 1 ? 0 : res;

//     }
// }
