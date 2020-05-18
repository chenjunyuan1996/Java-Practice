/*
152. 乘积最大子数组
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

链接：https://leetcode-cn.com/problems/maximum-product-subarray/
*/

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null) return 0;

        int cur_max = nums[0], cur_min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pre_max = cur_max;
            cur_max = Math.max(Math.max(pre_max * nums[i], cur_min * nums[i]), nums[i]);
            cur_min = Math.min(Math.min(pre_max * nums[i], cur_min * nums[i]), nums[i]);
            res = Math.max(res, cur_max);
        }
        return res;

    }
}
