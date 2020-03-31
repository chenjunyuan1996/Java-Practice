class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            while (i > 0 && nums[i] < nums[i - 1]) {
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
                i--;
            }
        }
        return nums;
    }
}
