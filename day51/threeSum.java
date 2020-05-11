class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] || nums[i] > 0) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int theSum = nums[i] + nums[j] + nums[k];
                if (theSum < 0) j++;
                else if (theSum > 0) k--;
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return res;
    }
}

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         Set<List<Integer>> res = new LinkedHashSet<>();
//         for (int i = 0; i < nums.length - 2; i++) {
//             if (i > 0 && nums[i] == nums[i - 1] || nums[i] > 0) continue;
//             Set<Integer> dic = new HashSet<>(nums.length - i);
//             for (int j = i + 1; j < nums.length; j++) {
//                 Integer tmp = - nums[i] - nums[j];
//                 if (dic.contains(nums[j])) {
//                     List<Integer> list = Arrays.asList(nums[i], tmp, nums[j]);
//                     res.add(list);
//                 } else {
//                     dic.add(tmp);
//                 }
//             }
//         }
//         return new ArrayList<>(res);
//     }
// }

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> result = new LinkedHashSet<>();

//         for (int i = 0; i < nums.length - 2; i++) {
//             int target = -nums[i];
//             Map<Integer, Integer> hashMap = new HashMap<>(nums.length - i);
//             for (int j = i + 1; j < nums.length; j++) {
//                 int v = target - nums[j];
//                 Integer exist = hashMap.get(v);
//                 if (exist != null) {
//                     List<Integer> list = Arrays.asList(nums[i], exist, nums[j]);
//                     list.sort(Comparator.naturalOrder());
//                     result.add(list);
//                 } else {
//                     hashMap.put(nums[j], nums[j]);
//                 }
//             }
//         }

//         return new ArrayList<>(result);
//     }
// }
