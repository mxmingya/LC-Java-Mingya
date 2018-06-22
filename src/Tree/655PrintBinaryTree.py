# Definition for a binary tree node.
class TreeNode():
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution():
    def printTree(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[str]]
        """
        if root is None:
            return None
        rows = {}
        cols = {}
        def recursion(self, root, row_index, col_index):
            return

