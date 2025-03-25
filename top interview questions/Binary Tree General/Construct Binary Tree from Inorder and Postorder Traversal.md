To construct a binary tree from given inorder and postorder traversal arrays, you can use a recursive approach. The key idea is to use the postorder array to determine the root of the tree and the inorder array to determine the left and right subtrees.

Here's the implementation of the `buildTree` method:

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> inorderMap;
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postorderIndex = postorder.length - 1;
        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = inorderMap.get(rootVal);
        root.right = buildTreeHelper(postorder, inorderIndex + 1, inorderEnd);
        root.left = buildTreeHelper(postorder, inorderStart, inorderIndex - 1);
        return root;
    }
}
```

### Explanation:
1. **Mapping Inorder Indices**:
   - `inorderMap = new HashMap<>();`: Create a map to store the indices of values in the inorder array for quick lookup.
   - `for (int i = 0; i < inorder.length; i++) { inorderMap.put(inorder[i], i); }`: Populate the map with the values and their indices from the inorder array.

2. **Initialize Postorder Index**:
   - `postorderIndex = postorder.length - 1;`: Initialize the index for the postorder array to the last element.

3. **Recursive Helper Method**:
   - `private TreeNode buildTreeHelper(int[] postorder, int inorderStart, int inorderEnd)`: This method constructs the tree recursively.
   - `if (inorderStart > inorderEnd) { return null; }`: Base case: If the start index is greater than the end index, return `null`.
   - `int rootVal = postorder[postorderIndex--];`: Get the root value from the postorder array and decrement the postorder index.
   - `TreeNode root = new TreeNode(rootVal);`: Create a new tree node with the root value.
   - `int inorderIndex = inorderMap.get(rootVal);`: Get the index of the root value in the inorder array.
   - `root.right = buildTreeHelper(postorder, inorderIndex + 1, inorderEnd);`: Recursively construct the right subtree.
   - `root.left = buildTreeHelper(postorder, inorderStart, inorderIndex - 1);`: Recursively construct the left subtree.
   - `return root;`: Return the constructed tree node.

### Example:
For the input `inorder = [9,3,15,20,7]` and `postorder = [9,15,7,20,3]`:

```
Inorder:   [9, 3, 15, 20, 7]
Postorder: [9, 15, 7, 20, 3]

Constructed Tree:
      3
     / \
    9   20
       / \
      15  7
```

For the input `inorder = [-1]` and `postorder = [-1]`:

```
Inorder:   [-1]
Postorder: [-1]

Constructed Tree:
    -1
```

This approach ensures that you construct the binary tree efficiently using the given inorder and postorder traversal arrays.

