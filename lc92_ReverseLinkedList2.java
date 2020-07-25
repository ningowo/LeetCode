public class lc92_ReverseLinkedList2 {
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        int position = 1;
        ListNode curr = new ListNode(0), beforeM = new ListNode(0), nodeM;

        // reach the specified range;
        while (position < m-1) { curr = curr.next; position++;}
        if (m != 1) { // 1st node
            beforeM = curr; // the m-1th node, to link left and range
            curr = curr.next;
            position++; // 1st -> mth
        } // this
        nodeM = curr; // the mth node, to link range and right

        ListNode prev = curr;
        curr = curr.next; position++; // mth -> m+1

        while (position <= n) { // start at (m-1, m, m+1)
            ListNode next = curr.next; // PUT IT INSIDE, if only use inside
            curr.next = prev;
            prev = curr;
            curr = next; position++;
        }
        // if range to be adjusted starts from the 1st node,
        // the new head should be the end in the range.
        if (m == 1) { head = prev; }
        else beforeM.next = prev;
        nodeM.next = curr;
        return head;
    }

    public static void main(String[] args) {
        ListNode t = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversed = reverseBetween(t, 2, 4);
        ListNode reversed1 = reverseBetween(t, 3, 5);
        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }

//        System.out.println("----------");
//        while (reversed1 != null) {
//            System.out.println(reversed1.val);
//            reversed1 = reversed1.next;
//        }
    }
}
