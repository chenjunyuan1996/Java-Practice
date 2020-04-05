// 冒泡排序

class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                    flag = true;
                }
            }
            if (flag == false) break;
        }
        return nums;
    }
}
