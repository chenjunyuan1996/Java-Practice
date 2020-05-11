/*
18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：答案中不可以包含重复的四元组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum
 */
 
 class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < size - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[size - 1] + nums[size - 2] < target) continue;

                int k = j + 1, l = size - 1;
                while (k < l) {
                    int theSum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (theSum < target) k++;
                    else if (theSum > target) l--;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++; l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }
        return res;
        
    }
}
