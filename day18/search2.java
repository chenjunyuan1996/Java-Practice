// 遍历
// class Solution {
//     public int search(int[] nums, int target) {
//         int res = 0;
//         for (int num: nums) {
//             if (num == target) {
//                 res++;
//             } else if (num > target) {
//                 break;
//             }
//         }
//         return res;
//     }
// }

// 二分法，找到第一个识别的数
class Solution {
    public int search(int[] nums, int target) {
        int res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    while (mid < nums.length && nums[mid] == target) {
                        res++;
                        mid++;
                    }
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return res;
    }
}
