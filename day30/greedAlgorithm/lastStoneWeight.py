'''
有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/last-stone-weight
'''

import heapq

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        maxHeap = []
        for stone in stones:
            heapq.heappush(maxHeap, -stone)
        while len(maxHeap) > 1 and maxHeap[0] != 0:
            head1 = heapq.heappop(maxHeap) 
            head2 = heapq.heappop(maxHeap)
            
            heapq.heappush(maxHeap, head1 - head2)
        return -maxHeap[0]

# class Solution:
#     def lastStoneWeight(self, stones: List[int]) -> int:
#         while len(stones) > 1:
#             stones.sort(reverse=True)
#             stones[0] -= stones.pop(1)
#         return stones[0]
