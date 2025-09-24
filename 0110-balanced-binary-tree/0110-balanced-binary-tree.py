# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return True if self.solve(root) >= 0 else False
        
    
    def solve(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        level = 1
        left_level = self.solve(root.left)
        right_level = self.solve(root.right)
        if abs(left_level - right_level) > 1:
            return -1
        if left_level == -1 or right_level == -1:
            return -1
        return level + max(left_level, right_level)