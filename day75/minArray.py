# class Solution:
#     def minArray(self, numbers: List[int]) -> int:
#         for i in range(1, len(numbers)):
#             if numbers[i] < numbers[i - 1]:
#                 return numbers[i]
#         return numbers[0]


class Solution:
    def minArray(self, numbers: [int]) -> int:
        l, r = 0, len(numbers) - 1
        while l < r:
            mid = l + ((r - l) >> 1)
            if numbers[l] > numbers[mid]:
                r = mid
            elif numbers[r] < numbers[mid]:
                l = mid + 1
            else:
                r -= 1
        return numbers[l]
