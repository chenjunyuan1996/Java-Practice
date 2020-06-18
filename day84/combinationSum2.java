/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明：所有数字（包括目标数）都是正整数。解集不能包含重复的组合。 

链接: https://leetcode-cn.com/problems/combination-sum-ii/
*/

class Solution {
    List<List<Integer>> res;
    int n;
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res = new LinkedList<>();
        this.n = candidates.length;
        Arrays.sort(candidates);
        this.candidates = candidates;
        helper(0, new LinkedList<Integer>(), target);
        
        return this.res;
    }

    private void helper(int i, LinkedList<Integer> tmp, int target) {
        if (target == 0) {
            this.res.add(new LinkedList(tmp));
            return;
        }
        if (i == this.n || target < candidates[i]) return;
        for (int j = i; j < this.n; j++) {
            if (i != j && candidates[j] == candidates[j - 1]) continue;
            tmp.add(candidates[j]);
            helper(j+1, tmp, target-candidates[j]);
            tmp.removeLast();
        }
        return;

    }
}
