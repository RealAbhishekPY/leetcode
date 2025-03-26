## code
```java
// Definition for a binary tree node.
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, TreeNode _left, TreeNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // Check if we have reached a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recursively check the left and right subtrees
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
```

### Explanation:

#### TreeNode Class:
1. **TreeNode Definition**: This class defines a node in a binary tree. Each node has an integer value (`val`), a left child (`left`), and a right child (`right`).
2. **Constructors**:
   - **Default Constructor**: Initializes an empty node.
   - **Single Parameter Constructor**: Initializes a node with a given value.
   - **Multi-Parameter Constructor**: Initializes a node with a given value, left child, and right child.

#### Solution Class:
1. **hasPathSum Method**: This method checks if there is a root-to-leaf path in the binary tree such that the sum of the values along the path equals `targetSum`.

2. **Base Case**:
   - **Null Check**: If the `root` is `null`, return `false` because there are no paths in an empty tree.

3. **Leaf Node Check**:
   - **Leaf Node**: If the current node is a leaf (both `left` and `right` children are `null`), check if the node's value equals the `targetSum`. If it does, return `true`; otherwise, return `false`.

4. **Recursive Check**:
   - **Remaining Sum**: Calculate the remaining sum by subtracting the current node's value from `targetSum`.
   - **Recursive Calls**: Recursively check the left and right subtrees with the updated `remainingSum`. If either subtree has a path that sums to the remaining sum, return `true`.

### Example:
For the input `root = [5,4,8,11,null,13,4,7,2,null,null,null,1]` and `targetSum = 22`, the function will return `true` because there is a path `5 -> 4 -> 11 -> 2` that sums to 22.

This code effectively checks for the existence of a path from the root to any leaf node that sums up to the given target sum using a recursive approach.

