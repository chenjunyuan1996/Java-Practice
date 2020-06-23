# class Solution:
#     def cuttingRope(self, n: int) -> int:
#         if n <= 3: return n - 1
#         a, b = n // 3, n % 3
#         if b == 0: return int(math.pow(3, a))
#         if b == 1: return int(math.pow(3, a - 1) * 4)
#         return int(math.pow(3, a) * 2)


class Solution:
    def cuttingRope(self, n: int) -> int:
        if n < 4:
            return n - 1

        count3, count2 = n // 3, n % 3
        if count2 == 1:
            count3 -= 1; count2 += 1
        else:
            count2 //= 2
        return pow(3, count3) * pow(2, count2)
