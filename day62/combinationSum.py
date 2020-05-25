class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates: return []        # 特殊情况

        self.res = []
        candidates.sort()                   # 为了方便剪枝，先排序
        self._backtrack(candidates, target, [])
        return self.res

    def _backtrack(self, candidates, target, cur):
        if target == 0:
            self.res.append(cur)
            return
    
        for j, num in enumerate(candidates):
            if target - num < 0: return     # 优先剪枝
            self._backtrack(candidates[j:],  target - num, cur + [num])
