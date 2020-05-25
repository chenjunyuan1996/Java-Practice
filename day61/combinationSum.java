/*
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：所有数字（包括 target）都是正整数。解集不能包含重复的组合。 

链接: https://leetcode-cn.com/problems/combination-sum/
*/


class Solution {
    public List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) return new LinkedList<>();

        Arrays.sort(candidates);
        backtrack(candidates, 0, candidates.length, target, new LinkedList<Integer>());
        return this.res;
    }

    private void backtrack(int[] candidates, int start, int end, int target, List<Integer> cur) {
        // 递归终止条件
        if (target == 0) {
            this.res.add(new LinkedList(cur));
            return;
        }

        for (int i = start; i < end; i++) {
            int num = candidates[i];
            // 剪枝
            if (target - num < 0) break;
            cur.add(num);
            backtrack(candidates, i, end, target - num, cur);
            cur.remove(new Integer(num));
        }

    }
}
