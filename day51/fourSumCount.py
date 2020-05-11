class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        res = 0
        dic = dict()
        for a in A:
            for b in B:
                dic[-a-b] = dic.get(-a-b, 0) + 1
        for c in C:
            for d in D:
                res += dic.get(c+d, 0)
        return res
