import java.util.Stack;

//傻到，以为是把输出再反过来
//update, 但是add two number II 就是做这个的...

//纠结的点是不知道创建空列表并且*从头*往里加元素
//解决的话是，1.用创建的.next去指head
//2.顺序是先赋值，在走下一个，要不然current没法指代两个。这样就能一个接一个往下走

class lc2_AddTwoNumbers1 {
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<>();
        boolean sign = false;
        ListNode result = new ListNode(0);
        ListNode list1 = l1;
        ListNode list2 = l2;

        while (list1 != null) {
            int sum = list1.val + list1.val;
            if (sum >= 10) {
                sign = true;
                sum -= 10;
            }

            if (sign) stack.push(sum + 1);
            else stack.push(sum);
            if (list1.next == null & sign) stack.push(1);
            sign = false;
            list1 = list1.next; list2 = list2.next;
        }

        ListNode current= result; // head前一个。
        while (!stack.empty()) {
            // current指最开始的话，就能指一次，之后就要用current.next了，所以直接指current.next
            current.next = new ListNode(stack.pop());
            current = current.next;
        }

        return result.next;
    }

    private static void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

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