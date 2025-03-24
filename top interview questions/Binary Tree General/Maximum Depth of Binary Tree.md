
``` java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
```


### Conceptual Explanation:

1. **Understanding Recursion**:
   - Recursion is a method where the solution to a problem depends on solutions to smaller instances of the same problem.
   - In the context of a binary tree, recursion can be used to traverse the tree and perform operations on each node.

2. **Base Case**:
   - The base case is the condition that stops the recursion. For the `maxDepth` method, the base case is when the `root` is `null`. This means we've reached the end of a branch (or the tree is empty), and the depth is `0`.

3. **Recursive Case**:
   - For each node, we need to calculate the depth of its left and right subtrees. This is done by making recursive calls to the `maxDepth` method for the left and right children of the node.

4. **Combining Results**:
   - Once we have the depths of the left and right subtrees, we need to determine the maximum depth of the current subtree. This is done by taking the maximum of the two depths and adding `1` to account for the current node.

### Step-by-Step Explanation:

1. **Check if the Node is Null**:
   - `if (root == null) { return 0; }`
   - If the current node (`root`) is `null`, it means we've reached the end of a branch, so we return `0`.

2. **Calculate Depth of Left Subtree**:
   - `int leftDepth = maxDepth(root.left);`
   - We make a recursive call to `maxDepth` for the left child of the current node. This will traverse the left subtree and return its depth.

3. **Calculate Depth of Right Subtree**:
   - `int rightDepth = maxDepth(root.right);`
   - Similarly, we make a recursive call to `maxDepth` for the right child of the current node. This will traverse the right subtree and return its depth.

4. **Determine Maximum Depth**:
   - `return Math.max(leftDepth, rightDepth) + 1;`
   - We take the maximum of the depths of the left and right subtrees and add `1` to account for the current node. This gives us the maximum depth of the subtree rooted at the current node.

### Visualizing the Process:

Consider the binary tree `[3,9,20,null,null,15,7]`:

```
      3
     / \
    9  20
       / \
      15  7
```

- Starting at the root (`3`), we calculate the depth of the left subtree (`9`) and the right subtree (`20`).
- For node `9`, both children are `null`, so the depth is `1`.
- For node `20`, we calculate the depth of its left subtree (`15`) and right subtree (`7`).
- Both `15` and `7` are leaf nodes, so their depths are `1`.
- The depth of node `20` is `2` (maximum of `1` and `1` plus `1`).
- Finally, the depth of the root node (`3`) is `3` (maximum of `1` and `2` plus `1`).

This recursive process ensures that we traverse the entire tree and calculate the maximum depth efficiently.
