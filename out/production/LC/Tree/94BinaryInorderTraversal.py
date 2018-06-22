
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ret = []

        if root is None:

            ret.append(root.val)
            return ret
        def helper(self, root):
            helper(self, root.left)
            ret.append(root.val)
            helper(self, root.right)
        helper(root)
        return ret