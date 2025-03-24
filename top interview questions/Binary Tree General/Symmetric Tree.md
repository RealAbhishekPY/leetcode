
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
}
```

### Explanation:
1. **Base Case**:
   - `if (root == null) { return true; }`: If the root is `null`, the tree is symmetric by definition.

2. **Recursive Case**:
   - `return isMirror(root.left, root.right);`: Check if the left and right subtrees are mirror images of each other.

3. **Helper Method `isMirror`**:
   - `private boolean isMirror(TreeNode t1, TreeNode t2)`: This method checks if two trees are mirror images of each other.
   - `if (t1 == null && t2 == null) { return true; }`: If both nodes are `null`, they are symmetric.
   - `if (t1 == null || t2 == null) { return false; }`: If one node is `null` and the other is not, they are not symmetric.
   - `return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);`: Check if the values of the current nodes are equal and recursively check if the right subtree of `t1` is a mirror of the left subtree of `t2` and vice versa.

### Example:
For the binary tree `root = [1,2,2,3,4,4,3]`:

```
      1
     / \
    2   2
   / \ / \
  3  4 4  3
```

- The tree is symmetric, so the output is `true`.

For the binary tree `root = [1,2,2,null,3,null,3]`:

```
      1
     / \
    2   2
     \   \
      3   3
```

- The tree is not symmetric, so the output is `false`.

This approach ensures that you compare all corresponding nodes and their subtrees to determine if the tree is symmetric.
