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
        
# class Solution:
#     def myPow(self, x: float, n: int) -> float:
#         def fastPow(x, n):
#             if n == 0: return 1
#             half = fastPow(x, n // 2)

#             if n % 2 == 0: return half * half
#             else: return half * half * x
        
#         if n < 0:
#             n = -n
#             x = 1 / x
#         return fastPow(x, n)
