class Solution:
    def countBits(self, num: int) -> List[int]:
        res = [0] * (num + 1)
        for i in range(1, num + 1):
            res[i] = res[i & i - 1] + 1
        return res 

# class Solution:
#     def countBits(self, num: int) -> List[int]:
#         res = [0]
#         for i in range(1, num + 1):
#             tmp = 0
#             while i != 0:
#                 i &= (i - 1)
#                 tmp += 1
#             res.append(tmp)
#         return res
