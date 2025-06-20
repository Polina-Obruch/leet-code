package org.yandex;

//Удалить n-й узел с конца
public class RemoveNthNodeFromEndOfList19 {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode low = head;
        ListNode prev = head;
        ListNode fast = head;

        for (int i = 1; i < n; ++i) {
            fast = fast.next;
        }

        while (fast != null) {
            if (fast.next == null) {
                //Если мы удаляем голову списка
                if (prev == low) {
                    head = low.next;
                    low.next = null;
                } else {
                    prev.next = low.next;
                }
                return head;
            }
            prev = low;
            low = low.next;
            fast = fast.next;
        }

        return head;
    }
}
