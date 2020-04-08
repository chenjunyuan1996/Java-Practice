/*
给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 */


class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];
        
        for (int num: nums) {
            count[num]++;
        }

        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[i] = count[nums[i] - 1];
            }
        }
        
        return res;
    }
}
