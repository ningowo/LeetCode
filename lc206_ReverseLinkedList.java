
public class lc206_ReverseLinkedList {
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    public static void main(String[] args) {
        ListNode t = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode reversed = reverseList(t);
        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
}
