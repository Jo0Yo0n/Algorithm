# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.solve(root) >= 0
        
    
    def solve(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        left_level = self.solve(root.left)
        right_level = self.solve(root.right)
        if left_level == -1 or right_level == -1:
            return -1
        if abs(left_level - right_level) > 1:
            return -1
        return 1 + max(left_level, right_level)