/*
41. 缺失的第一个正数
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
提示：你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。

链接: https://leetcode-cn.com/problems/first-missing-positive/
*/

// 通过改变原数组的顺序，把数字方式到对应的位置上，再进行一遍遍历，得到与位置不相符的第一个数，因为是原地改变，故无需额外的空间
class Solution {
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            while (nums[i] >= 1 && nums[i] <= size && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < size; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return size + 1;

    }
}

// 增加额外空间版本
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         int size = nums.length;
//         int[] count = new int[size + 1];
//         for (int num : nums) {
//             if (num > 0 && num <= size) {
//                 count[num]++;
//             }
//         }
//         for (int i = 1; i <= size; i++) {
//             if (count[i] == 0)
//                 return i;
//         }
//         return size + 1;
//     }
// }
