class Solution {

    private static void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return;
    }

    public static void quickSort(int nums[], int left, int right){
        if (left >= right) { return; }
        int pivot = left;
        int end = right;
        while (left < right) {
            while (left < right && nums[right] >= nums[pivot]) {
                right--;
            }
            while (left < right && nums[left] <= nums[pivot]) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, left, pivot);
        quickSort(nums, pivot, left - 1);
        quickSort(nums, left + 1, end);
    }
        
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}
