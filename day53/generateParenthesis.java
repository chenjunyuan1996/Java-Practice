/*
22. 括号生成
 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

https://leetcode-cn.com/problems/generate-parentheses/
*/

class Solution {
    public List<String> res;

    public List<String> generateParenthesis(int n) {
        this.res = new LinkedList<>();
        genOne(n, n, "");
        return this.res;
    }

    private void genOne(int left, int right, String subList) {
        if (right == 0) {
            this.res.add(subList);
            return;
        }

        if (left != 0) genOne(left - 1, right, subList + "(");
        if (right > left) genOne(left, right - 1, subList + ")");
    }
}
