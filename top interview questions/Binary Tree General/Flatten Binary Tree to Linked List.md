``` java
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
    public void flatten(TreeNode root) {
        TreeNode current = root;
        
        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node in the left subtree
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                // Connect the right subtree to the rightmost node
                rightmost.right = current.right;
                // Move the left subtree to the right
                current.right = current.left;
                current.left = null;
            }
            // Move to the next node
            current = current.right;
        }
    }
}
```
## Explanation

### TreeNode Class:
1. **TreeNode Definition**: This class defines a node in a binary tree. Each node has an integer value (`val`), a left child (`left`), and a right child (`right`).
2. **Constructors**:
   - **Default Constructor**: Initializes an empty node.
   - **Single Parameter Constructor**: Initializes a node with a given value.
   - **Multi-Parameter Constructor**: Initializes a node with a given value, left child, and right child.

### Solution Class:
1. **flatten Method**: This method flattens the binary tree into a "linked list" in-place, following a pre-order traversal.

2. **Current Node**:
   - **Initialization**: Start with the root node (`current = root`).

3. **While Loop**:
   - **Traversal**: Iterate through the tree using a while loop (`while (current != null)`).

4. **Left Subtree Check**:
   - **Check**: If the current node has a left child (`if (current.left != null)`), proceed with the flattening process.

5. **Find Rightmost Node**:
   - **Initialization**: Start with the left child (`TreeNode rightmost = current.left`).
   - **Traversal**: Find the rightmost node in the left subtree (`while (rightmost.right != null)`).

6. **Reconnection**:
   - **Connect Right Subtree**: Connect the right subtree of the current node to the rightmost node of the left subtree (`rightmost.right = current.right`).

7. **Move Left to Right**:
   - **Move Subtree**: Move the left subtree to the right (`current.right = current.left`).
   - **Set Left to Null**: Set the left child to `null` (`current.left = null`).

8. **Move to Next Node**:
   - **Next Node**: Move to the next node in the right subtree (`current = current.right`).

### Example:
For the input `root = [1,2,5,3,4,null,6]`, the tree will be flattened to:
- `1 -> 2 -> 3 -> 4 -> 5 -> 6`

### Summary:
- **Pre-order Traversal**: The tree is flattened in the order of a pre-order traversal.
- **In-place**: The flattening is done in-place with O(1) extra space.
- **Linked List**: The resulting structure is a "linked list" where each node's right child points to the next node in the list, and the left child is always `null`.

