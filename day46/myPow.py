class Solution:
    def myPow(self, x: float, n: int) -> float:
        res = 1
        i = n if n > 0 else -n
        
        while i != 0:
            if i % 2 != 0:
                res *= x
            x *= x
            i //= 2

        return res if n > 0 else 1 / res
