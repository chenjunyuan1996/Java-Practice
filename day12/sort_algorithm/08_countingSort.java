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

/*
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {
            int max = nums[0], min = nums[0];
            for (int n: nums) {
                if (max < n) max = n;
                if (min > n) min = n;
            }
            int[] count = new int[max - min + 1];
            for (int n: nums) {
                count[n - min]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            int[] res = new int[nums.length];
            for (int i = nums.length - 1; i > -1; i--) {
                res[--count[nums[i] - min]] = nums[i];
            }
            nums = res;
        }
        return nums;
    }
}
*/
