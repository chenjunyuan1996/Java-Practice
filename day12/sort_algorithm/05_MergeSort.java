class Solution {
    private static void mergeArray(int nums[], int first, int mid, int last){
        int i = first, j = mid + 1; // 设置两个数组的起始边界
        int m = mid, n = last; // 设置两个数组的结束边界
        int[] temp = new int[last - first + 1];
        int k = 0;

        while (i <= m && j <= n){
            if(a[i] <= a[j]){
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= m){
            temp[k++] = nums[i++];
        }

        while (j <= n){ 
            temp[k++] = nums[j++];
        }

        for(i = 0; i < k; i++){
            nums[first+i] = temp[i];
        }
    }

   /**
    * @param nums 待排数组
    * @param first 数组的起始下标
    * @param last 数组的结束下标
    */
    public static void MergeSort(int[] nums, int first, int last){
        if(first < last) {
            int mid = (first + last) / 2;

            mergeSort(nums, first, mid); // 左边排序
            mergeSort(nums, mid + 1, last); // 右边排序

            mergeArray(nums, first, mid, last); // 再将两个有序序列合并.
        }
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}
