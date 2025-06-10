package org.yandex;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 */

public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = new ListNode();
        ListNode prev = current;
        int rememberVal = 0;

        //Пока хотя бы одно выполняется
        while (l1 != null || l2 != null || rememberVal != 0) {
            int currentVal = rememberVal;

            if (l1 != null) {
                currentVal += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                currentVal += l2.val;
                l2 = l2.next;
            }

            if (currentVal >= 10) {
                currentVal = currentVal % 10;
                rememberVal = 1;
            } else {
                rememberVal = 0;
            }

            current.next = new ListNode(currentVal);
            current = current.next;
        }
        return prev.next;
    }
}
