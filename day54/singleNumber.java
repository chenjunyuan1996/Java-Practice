class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums)
            single ^= num;
        
        return single;
    }
}

// class Solution {
//     public int singleNumber(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();

//         for (int num : nums) {
//             map.put(num, 1 + map.getOrDefault(num, 0));
//         }
        
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             if (entry.getValue() == 1) return entry.getKey();
//         }

//         throw new NumberFormatException();
//     }
// }

// class Solution {
//     public int singleNumber(int[] nums) {
//         Arrays.sort(nums);
//         int i = 0;
//         while (i < nums.length - 1) {
//             if (nums[i] == nums[i + 1]) {
//                 i += 2;
//             } else {
//                 return nums[i];
//             }
//         }
//         return nums[nums.length - 1];
//     }
// }
