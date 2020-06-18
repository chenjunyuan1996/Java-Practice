class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates: return list()

        candidates.sort(reverse=True)
        res = []
        def helper(i, tmp, target):
            if (target == 0):
                res.append(tmp)
                return
            if (i < 0 or target < candidates[i]): return

            for j in range(i, -1, -1):
                if j < i and candidates[j] == candidates[j+1]: continue
                helper(j-1, tmp+[candidates[j]], target-candidates[j])
        
        helper(len(candidates) - 1, list(), target)
        return res
