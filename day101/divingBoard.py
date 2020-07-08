class Solution:
    def divingBoard(self, shorter: int, longer: int, k: int) -> List[int]:
        if not k: return []
        if shorter == longer: return [shorter * k]
    
        res = [shorter * (k - i) + longer * i for i in range(k + 1)]
        return res
