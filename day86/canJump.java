/*
55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个位置。

链接: https://leetcode-cn.com/problems/jump-game/
*/

class Solution {
    public boolean canJump(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (length >= i && length < i + nums[i]) {
                length = i + nums[i];
            }
        }
        return length >= nums.length - 1;

    }
}
