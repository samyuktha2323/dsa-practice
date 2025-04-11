package dsa;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head, int pos) {
        if (pos == 0) {
            return false;
        }

        ListNode loopStartNode = null;
        ListNode current = head;
        int index = 1;

        while (current != null && index < pos) {
            current = current.next;
            index++;
        }
        loopStartNode = current;

        current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }

        if (current != null) {
            current.next = loopStartNode;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}