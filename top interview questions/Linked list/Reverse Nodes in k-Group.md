## code 
``` java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                kthNode = kthNode.next;
                if (kthNode == null) {
                    return dummy.next;
                }
            }

            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = kthNode.next;

            prevGroupEnd.next = reverse(groupStart, groupEnd);
            groupStart.next = groupEnd;
            prevGroupEnd = groupStart;
        }
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode current = start;
        while (current != end) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
```