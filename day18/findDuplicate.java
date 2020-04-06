/*
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int count = 0;
            for (int num: nums) {
                if (num < mid) {
                    count++;
                }
            }

            if (count < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
