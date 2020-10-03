package LC;

public class ListNode {

    static ListNode ordered1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    static ListNode ordered2 = new ListNode(4, new ListNode(5, new ListNode(6)));

    static ListNode unordered1 = new ListNode(3, new ListNode(1, new ListNode(2)));
    static ListNode unordered2 = new ListNode(6, new ListNode(5, new ListNode(4)));

    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {

    }
}
