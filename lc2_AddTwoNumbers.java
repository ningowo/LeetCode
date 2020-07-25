/**
 * 纠结的点是不知道创建空列表并且*从头*往里加元素
 * 解决的话是，1.用创建的.next去指head
 * 2.顺序是先赋值，在走下一个，要不然current没法指代两个。这样就能一个接一个往下走
 * current指最开始的话，就能指一次，之后就要用current.next了，所以直接指current.next
 * 3. sign，如果最终结果是要加个数的话，可以直接把sign用数字表示
 * 4. if (sum >= 10) { sign = 1; } --> sign = sum / 10
 */
class lc2_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode beforeHead = new ListNode(0);
        int sign = 0;
        ListNode curr = beforeHead;

        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;

            int sum = x + y + sign;
            sign = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (sign == 1) curr.next = new ListNode(1);

        return beforeHead.next;
    }

    public ListNode betterAddTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }

    public static void test() {
        ListNode l1 = new ListNode(8);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(2);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode test = addTwoNumbers(l1, l2);
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }

    public static void main(String[] args) {
        test();
    }

}