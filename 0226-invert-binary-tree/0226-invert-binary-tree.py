# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.recursive(root)

        return root
    
    def recursive(self, node: Optional[TreeNode]):
        if not node:
            return
        
        self.recursive(node.left)
        self.recursive(node.right)
        
        temp = node.left
        node.left = node.right
        node.right = temp