To construct a binary tree from given preorder and inorder traversal arrays, you can use a recursive approach. The key idea is to use the preorder array to determine the root of the tree and the inorder array to determine the left and right subtrees.

Here's the implementation of the `buildTree` method:

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> inorderMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        preorderIndex = 0;
        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = inorderMap.get(rootVal);
        root.left = buildTreeHelper(preorder, inorderStart, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorderIndex + 1, inorderEnd);
        return root;
    }
}
```

### Explanation:
1. **Mapping Inorder Indices**:
   - `inorderMap = new HashMap<>();`: Create a map to store the indices of values in the inorder array for quick lookup.
   - `for (int i = 0; i < inorder.length; i++) { inorderMap.put(inorder[i], i); }`: Populate the map with the values and their indices from the inorder array.

2. **Initialize Preorder Index**:
   - `preorderIndex = 0;`: Initialize the index for the preorder array.

3. **Recursive Helper Method**:
   - `private TreeNode buildTreeHelper(int[] preorder, int inorderStart, int inorderEnd)`: This method constructs the tree recursively.
   - `if (inorderStart > inorderEnd) { return null; }`: Base case: If the start index is greater than the end index, return `null`.
   - `int rootVal = preorder[preorderIndex++];`: Get the root value from the preorder array and increment the preorder index.
   - `TreeNode root = new TreeNode(rootVal);`: Create a new tree node with the root value.
   - `int inorderIndex = inorderMap.get(rootVal);`: Get the index of the root value in the inorder array.
   - `root.left = buildTreeHelper(preorder, inorderStart, inorderIndex - 1);`: Recursively construct the left subtree.
   - `root.right = buildTreeHelper(preorder, inorderIndex + 1, inorderEnd);`: Recursively construct the right subtree.
   - `return root;`: Return the constructed tree node.

### Example:
For the input `preorder = [3,9,20,15,7]` and `inorder = [9,3,15,20,7]`:

```
Preorder: [3, 9, 20, 15, 7]
Inorder:  [9, 3, 15, 20, 7]

Constructed Tree:
      3
     / \
    9   20
       / \
      15  7
```

For the input `preorder = [-1]` and `inorder = [-1]`:

```
Preorder: [-1]
Inorder:  [-1]

Constructed Tree:
    -1
```

This approach ensures that you construct the binary tree efficiently using the given preorder and inorder traversal arrays.

