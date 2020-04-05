/*
数组的相对排序

给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-sort-array
 */


class Solution {
    private int[] count;
    private int[] res;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        count = new int[1001];
        res = new int[arr1.length];

        for (int n: arr1) {
            count[n]++;
        }

        int pivot = 0;
        for (int n: arr2) {
            while (count[n] > 0) {
                res[pivot] = n;
                pivot++;
                count[n]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (count[i] > 0) {
                res[pivot] = i;
                pivot++;
                count[i]--;
            }
        }

        return res;
    }
}
