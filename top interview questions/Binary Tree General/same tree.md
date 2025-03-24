To check if two binary trees are the same, you can use a recursive approach. The idea is to compare the values of the corresponding nodes and ensure that both the left and right subtrees are also identical.

Here's the implementation of the `isSameTree` method:

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

### Explanation:
1. **Base Case**:
   - `if (p == null && q == null) { return true; }`: If both nodes are `null`, the trees are identical up to this point.
   - `if (p == null || q == null) { return false; }`: If one node is `null` and the other is not, the trees are not identical.

2. **Value Comparison**:
   - `if (p.val != q.val) { return false; }`: If the values of the current nodes are different, the trees are not identical.

3. **Recursive Case**:
   - `return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);`: Recursively check the left and right subtrees. Both subtrees must be identical for the trees to be considered the same.

### Example:
For the binary trees `p = [1,2,3]` and `q = [1,2,3]`:

```
Tree p:       Tree q:
    1             1
   / \           / \
  2   3         2   3
```

- The trees are structurally identical and have the same values, so the output is `true`.

For the binary trees `p = [1,2]` and `q = [1,null,2]`:

```
Tree p:       Tree q:
    1             1
   /               \
  2                 2
```

- The trees are not structurally identical, so the output is `false`.

This approach ensures that you compare all corresponding nodes and their subtrees to determine if the trees are the same.
