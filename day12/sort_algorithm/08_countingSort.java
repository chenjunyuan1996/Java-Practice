class Solution {
        
    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {

            int nmax = nums[0];
            int nmin = nums[0];
            for (int num: nums) {
                if (num > nmax) nmax = num;
                if (num < nmin) nmin = num;
            }
            int n = nmax - nmin + 1;

            var arr = new int[n];
            for (int num: nums) {
                arr[num - nmin]++;
            }

            int pivot = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    nums[pivot] = nmin + i;
                    pivot++;
                }
            }
        }
        return nums;
    }
}
