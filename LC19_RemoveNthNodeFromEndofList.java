package LC;

public class LC19_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode beforeNth = head;
        ListNode cur = head;

        while (n-- != 0) cur = cur.next; // execute for n times

        // if need to delete the very first one, cur points to the next of the last node
        if (cur == null) return head.next;

        while (cur.next != null) {
            beforeNth = beforeNth.next;
            cur = cur.next;
        }

        beforeNth.next = beforeNth.next.next;
        return head;
    }
}
