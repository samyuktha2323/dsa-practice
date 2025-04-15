package dsa2;

import java.util.HashMap;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class RemoveZeroSumSublists {

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        HashMap<Integer, ListNode> prefixMap = new HashMap<>();
        int prefixSum = 0;
        ListNode current = dummy;

        // First pass: map prefix sum to node
        while (current != null) {
            prefixSum += current.val;
            prefixMap.put(prefixSum, current);
            current = current.next;
        }

        // Second pass: skip nodes in zero-sum ranges
        prefixSum = 0;
        current = dummy;
        while (current != null) {
            prefixSum += current.val;
            current.next = prefixMap.get(prefixSum).next;
            current = current.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the linked list: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Linked list is empty.");
            return;
        }

        System.out.println("Enter the node values:");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int i = 0; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        ListNode updatedHead = removeZeroSumSublists(dummy.next);

        System.out.println("Linked list after removing zero-sum sequences:");
        printList(updatedHead);

        scanner.close();
    }
}
