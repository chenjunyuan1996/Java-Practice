/*
189. 旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

链接: https://leetcode-cn.com/problems/rotate-array/
*/

class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k %= size;
        if (k != 0) {
            int count = fun(size, k);
            for (int i = 0; i < count; i++) {
                int current = i;
                int prev = nums[i];
                do {
                    int next = (current + k) % size;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                } while (i != current);
            }
        }
    }

//     public int fun(int a, int b) {
//         int tmp = a % b;
//         while (tmp != 0) {
//             a = b;
//             b = tmp;
//             tmp = a % b;
//         }
//         return b;
//     }
// }


// public class Solution {
//     public void rotate(int[] nums, int k) {
//         k = k % nums.length;
//         if (k != 0) {
//             int count = 0;
//             for (int start = 0; count < nums.length; start++) {
//                 int current = start;
//                 int prev = nums[start];
//                 do {
//                     int next = (current + k) % nums.length;
//                     int temp = nums[next];
//                     nums[next] = prev;
//                     prev = temp;
//                     current = next;
//                     count++;
//                 } while (start != current);
//             }
//         }
//     }
// }
