# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        res = ListNode(0)
        res.next = head
        cur = res
        while cur.next and cur.next.next:
            first = cur.next
            second = cur.next.next

            # swap
            cur.next = second
            first.next = second.next
            second.next = first

            cur = first
        return res.next
