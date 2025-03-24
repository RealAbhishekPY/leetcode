
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
```

### Explanation:
1. **Base Case**:
   - `if (root == null) { return null; }`: If the current node is `null`, return `null`. This stops the recursion when you reach the end of a branch.

2. **Swap Children**:
   - `TreeNode temp = root.left;`: Store the left child in a temporary variable.
   - `root.left = root.right;`: Assign the right child to the left child.
   - `root.right = temp;`: Assign the temporary variable (original left child) to the right child.

3. **Recursive Calls**:
   - `invertTree(root.left);`: Recursively invert the left subtree.
   - `invertTree(root.right);`: Recursively invert the right subtree.

4. **Return Root**:
   - `return root;`: Return the root of the inverted tree.

### Example:
For the binary tree `root = [4,2,7,1,3,6,9]`:

```
Original Tree:
      4
     / \
    2   7
   / \ / \
  1  3 6  9

Inverted Tree:
      4
     / \
    7   2
   / \ / \
  9  6 3  1
```

For the binary tree `root = [2,1,3]`:

```
Original Tree:
    2
   / \
  1   3

Inverted Tree:
    2
   / \
  3   1
```

For the binary tree `root = []`:

```
Original Tree:
    (empty)

Inverted Tree:
    (empty)
```

This approach ensures that you swap the children of every node in the tree, effectively inverting the entire tree.

