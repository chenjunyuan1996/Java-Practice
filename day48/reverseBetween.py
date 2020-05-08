# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        res = ListNode(0)
        res.next = head
        pivot = res
        for _ in range(m - 1):
            pivot = pivot.next

        cur = pivot.next
        for _ in range(n - m):
            temp = cur.next
            cur.next = temp.next
            temp.next = pivot.next
            pivot.next = temp

        return res.next
