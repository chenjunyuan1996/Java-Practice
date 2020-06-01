/*
1431. 拥有最多糖果的孩子
给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。

链接: https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
*/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }
        
        List<Boolean> res = new LinkedList<>();
        for (int candy : candies) {
            res.add(candy + extraCandies >= maxCandy);
        }

        return res;

    }
}
