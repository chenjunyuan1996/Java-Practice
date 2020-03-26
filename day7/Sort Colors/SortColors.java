class Solution {
    public void sortColors(int[] nums) {
        int cur = 0;
        int left = 0;
        int right = nums.length - 1;
        while (cur <= right) {
            if (nums[cur] == 0) {
                int tmp = nums[cur];
                nums[cur] = nums[left];
                nums[left] = tmp;
                left++;
                cur++;
            }
            else if (nums[cur] == 2) {
                int tmp = nums[cur];
                nums[cur] = nums[right];
                nums[right] = tmp;
                right--;
            }
            else {
                cur++;
            }
        }

    }
}
