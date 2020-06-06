/*
128. 最长连续序列
给定一个未排序的整数数组，找出最长连续序列的长度。
要求: 算法的时间复杂度为 O(n)。

链接: https://leetcode-cn.com/problems/longest-consecutive-sequence/
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) continue;

            int cur = num + 1, tmp = 1;
            while (set.contains(cur)) {
                cur++;
                tmp++;
            }
            res = Math.max(res, tmp);
        }

        return res;

    }
}
