class Solution:
    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        res = []
        k = 0
        for i in range(len(seq)):
            if seq[i] == "(":
                res.append(k % 2)
                k += 1
            else:
                k -= 1
                res.append(k % 2)
        return res
