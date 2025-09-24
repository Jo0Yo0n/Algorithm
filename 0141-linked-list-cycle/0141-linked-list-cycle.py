# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        start_node = head
        
        while head:
            if head.next == start_node:
                return True
            elif not head.next:
                return False
            
            temp = head
            head = head.next
            temp.next = start_node

        return False