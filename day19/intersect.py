class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        count = {}
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
            
        for num in nums2:
            if num not in count:
                count[num] = 1
            else:
                count[num] += 1
        
        res = []
        for num in nums1:
            if num in count and count[num] > 0:
                res.append(num)
                count[num] -= 1
        return res
