/*
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

链接: https://leetcode-cn.com/problems/3sum-closest/
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = (int) 1e5;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int cur = nums[i] + nums[l] + nums[r];
                if (cur == target) return target;
                else if (cur > target) r--;
                else if (cur < target) l++;

                if (Math.abs(cur - target) < Math.abs(res - target))
                    res = cur;
            }
        }
        return res;

    }
}
