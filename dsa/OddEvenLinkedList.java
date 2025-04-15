package dsa2;

import java.util.Scanner;

class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        OddEvenLinkedList solution = new OddEvenLinkedList();
        ListNode newHead = solution.oddEvenList(dummy.next);

        System.out.println("Odd-Even rearranged linked list:");
        printList(newHead);

        scanner.close();
    }
}