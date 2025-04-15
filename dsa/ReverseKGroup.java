package dsa2;

import java.util.Scanner;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy, end = dummy;

        while (true) {
            int count = 0;
            while (end != null && count < k) {
                end = end.next;
                count++;
            }
            if (end == null) break;

            ListNode start = prevGroup.next;
            ListNode nextGroup = end.next;
            end.next = null;

            prevGroup.next = reverse(start);
            start.next = nextGroup;

            prevGroup = start;
            end = start;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }

    public static void printList(ListNode head) {
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

        System.out.println("Enter the values of the nodes:");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        ReverseKGroup solution = new ReverseKGroup();
        ListNode newHead = solution.reverseKGroup(dummy.next, k);

        System.out.println("Reversed Linked List in groups of " + k + ":");
        printList(newHead);

        scanner.close();
    }
}
