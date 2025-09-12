# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head1 = list1
        head2 = list2
        ans = ListNode(0)
        current = ans

        while head1 and head2:
            if head1.val < head2.val:
                temp = ListNode(head1.val)
                current.next = temp
                current = current.next
                head1 = head1.next
            else:
                temp = ListNode(head2.val)
                current.next = temp
                current = current.next
                head2 = head2.next

        while head1:
            temp = ListNode(head1.val)
            current.next = temp
            current = current.next
            head1 = head1.next
        while head2:
            temp = ListNode(head2.val)
            current.next = temp
            current = current.next
            head2 = head2.next

        return ans.next