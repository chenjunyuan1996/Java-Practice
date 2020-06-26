# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeDuplicateNodes(self, head: ListNode) -> ListNode:
        if not head: 
            return head
        
        dic = {head.val}
        cur = head
        while cur.next:
            if cur.next.val in dic:
                cur.next = cur.next.next
            else:
                dic.add(cur.next.val)
                cur = cur.next
        return head
