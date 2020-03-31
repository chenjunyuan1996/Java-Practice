class Solution {
    public int[] sortArray(int[] nums) {
        int gap = nums.length / 2;
        while (gap > 0) {
            for (int i = gap; i < nums.length; i++) {
                while (i - gap >= 0 && nums[i - gap] > nums[i]) {
                    int tmp = nums[i - gap];
                    nums[i - gap] = nums[i];
                    nums[i] = tmp;
                    i--;
                }
            }
            gap /= 2;
        }
        return nums;
    }
}
