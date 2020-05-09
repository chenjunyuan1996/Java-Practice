/*
239. 滑动窗口最大值
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sliding-window-maximum
 */

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> win = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && win.peekFirst() <= i - k)
                win.pollFirst();
            while (!win.isEmpty() && nums[win.peekLast()] < nums[i])
                win.pollLast();
            win.offerLast(i);
            if (i >= k - 1)
                res[i - k + 1] = nums[win.peekFirst()];
        }
        return res;
    }
}
