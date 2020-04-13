/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */

class Solution {
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int n) {
        if (n == 1) {
            List<Integer> temp = new LinkedList<>();
            for (int num: nums) {
                temp.add(num);
            }
            res.add(temp);
        }

        for (int i = 0; i < n; i++) {
            swap(nums, i, n - 1);
            backtrack(res, nums, n - 1);
            swap(nums, i, n - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
    
        backtrack(res, nums, nums.length);
        return res;
    }
}
