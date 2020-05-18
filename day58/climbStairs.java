/*
70. 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
*/

class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}

// class Solution {
//     private int[] dic;
    
//     public int climbStairs(int n) {
//         this.dic = new int[n + 1];
//         this.dic[0] = 1;
//         this.dic[1] = 1;
//         return climb(n);
//     }

//     private int climb(int n) {
//         if (this.dic[n] > 0) return this.dic[n];

//         this.dic[n] = climb(n - 1) + climb(n - 2);
//         return this.dic[n];
//     }
// }
