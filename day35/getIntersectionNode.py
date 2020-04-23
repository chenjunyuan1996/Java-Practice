# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


# 双指针(存在不相交的情况)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        curA, curB = headA, headB
        while curA != curB:
            curA = curA.next if curA else headB
            curB = curB.next if curB else headA
        return curA

# 暴力法
# class Solution:
#     def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
#         curA = headA
#         while curA:
#             curB = headB
#             while curB:
#                 if curB == curA: return curB
#                 curB = curB.next
#             curA = curA.next
#         return curA

# 哈希表
# class Solution:
#     def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
#         dic = collections.defaultdict()
#         while headA:
#             dic[headA] = 1
#             headA = headA.next
#         while headB:
#             if headB in dic: return headB
#             headB = headB.next
