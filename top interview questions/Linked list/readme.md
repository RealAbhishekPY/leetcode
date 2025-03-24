Linked lists are a fundamental data structure used in various data structures and algorithms (DSA) problems. They consist of nodes where each node contains data and a reference (or link) to the next node in the sequence. Linked lists are particularly useful for problems that require dynamic memory allocation, efficient insertions/deletions, and flexible data structures.
---
### Types of Linked Lists:
1. **Singly Linked List**: Each node points to the next node.
2. **Doubly Linked List**: Each node points to both the next and the previous node.
3. **Circular Linked List**: The last node points back to the first node, forming a circle.

### Basic Operations:
1. **Insertion**: Adding a new node to the list.
2. **Deletion**: Removing a node from the list.
3. **Traversal**: Accessing each node in the list.
4. **Search**: Finding a node with a specific value.

### Example of a Singly Linked List in Java:

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class LinkedList {
    ListNode head;

    // Insert a new node at the beginning
    public void insertAtBeginning(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    // Insert a new node at the end
    public void insertAtEnd(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete a node with a specific value
    public void deleteNode(int val) {
        if (head == null) return;
        if (head.val == val) {
            head = head.next;
            return;
        }
        ListNode temp = head;
        while (temp.next != null && temp.next.val != val) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Print the linked list
    public void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
```

### Example Usage:

```java
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBeginning(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.printList(); // Output: 1 2 3
        list.deleteNode(2);
        list.printList(); // Output: 1 3
    }
}
```

### Common DSA Problems Using Linked Lists:
1. **Reverse a Linked List**: Reverse the pointers of the list.
2. **Detect a Cycle in a Linked List**: Use Floyd’s Cycle-Finding Algorithm.
3. **Merge Two Sorted Linked Lists**: Merge two sorted lists into one sorted list.
4. **Find the Middle of a Linked List**: Use the slow and fast pointer technique.
5. **Remove N-th Node from End of List**: Use two pointers to find and remove the node.

### Example: Reverse a Linked List

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
```

### Explanation:
- **Reverse a Linked List**: Initialize `prev` to `null` and `curr` to `head`. Iterate through the list, reversing the pointers one by one until the end of the list is reached. Finally, return `prev` as the new head of the reversed list.

Linked lists are versatile and can be used to solve a wide range of problems in data structures and algorithms.
