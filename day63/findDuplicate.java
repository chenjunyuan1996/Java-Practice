class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        throw new NumberFormatException();

    }
}

// class Solution {
//     public int findDuplicate(int[] nums) {
//         int bit = (1 << nums.length) - 1;
//         for (int num : nums) {
//             int pivot = (1 << num);
//             if ((bit & pivot) == 0) {
//                 return num;
//             }
//             bit -= pivot;
//         }
//         throw new NumberFormatException();

//     }
// }

// class Solution {
//     public int findDuplicate(int[] nums) {
//         int left = 1, right = nums.length - 1;

//         while (left <= right) {
//             int mid = left + ((right - left) >> 1);
//             int count = 0;
//             for (int num : nums) {
//                 if (num < mid) count++;
//             }

//             if (count < mid) {
//                 left = ++mid;
//             } else {
//                 right = --mid;
//             }
//         }
//         return right;

//     }
// }
