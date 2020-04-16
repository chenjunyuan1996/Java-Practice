'''
给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sub-sort-lcci
'''

class Solution:
    def subSort(self, array: List[int]) -> List[int]:
        if not array: return [-1, -1]
        l = r = -1
        rmax = array[0]
        lmin = array[-1]
        for i in range(1, len(array)):
            if array[i] > rmax:
                rmax = array[i]
            elif array[i] < rmax:
                r = i
        for i in range(len(array) -2, -1, -1):
            if array[i] < lmin:
                lmin = array[i]
            elif array[i] > lmin:
                l = i
        return [l, r]

# class Solution:
#     def subSort(self, array: List[int]) -> List[int]:
        # tmp = sorted(array)
        # m = 0
        # n = len(array) - 1
        # while m <= n and tmp[m] == array[m]:
        #     m += 1
        # if m >= n:
        #     return [-1, -1]
        # else:
        #     while tmp[n] == array[n]:
        #         n -= 1
        #     return [m, n]
