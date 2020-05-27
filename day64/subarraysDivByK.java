/*
974. 和可被 K 整除的子数组
给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。

链接: https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
*/

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int total = 0, res = 0;

        for (int elem : A) {
            total += elem;
            int modulus = (total % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            res += same;
            record.put(modulus, same + 1);
        }

        return res;

    }
}
