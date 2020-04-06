/*
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
 */

class Solution {
   public int mySqrt(int x) {
        long left = 0;
        long right = x / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sqr = mid * mid;
            long nextSqr = (mid + 1) * (mid + 1);

            if (sqr <= x && x < nextSqr) {
                return (int) mid;
            } else if (sqr > x) {
                right = mid - 1;
            } else if (sqr < x) {
                left = mid + 1;
            }
        }
        return x;
    }
}
