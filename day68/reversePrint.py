# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reversePrint(self, head: ListNode) -> List[int]:
        return self.reversePrint(head.next) + [head.val] if head else []

# class Solution:
#     def reversePrint(self, head: ListNode) -> List[int]:
#         cur = head
#         res = []
#         while cur != None:
#             res.append(cur.val)
#             cur = cur.next
#         return res[::-1]
