/*
238. 除自身以外数组的乘积
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
进阶：你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

链接: https://leetcode-cn.com/problems/product-of-array-except-self/
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        int tmp = 1;
        for (int i = 0; i < size; i++) {
            res[i] = tmp;
            tmp *= nums[i];
        }

        tmp = 1;
        for (int i = size - 1; i >= 0; i--) {
            res[i] *= tmp;
            tmp *= nums[i];
        }

        return res;

    }
}
