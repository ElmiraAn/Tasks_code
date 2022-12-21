public class AddTwoNumbers_2 {
    public static void main(String[] params) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        //ListNode l1 =new ListNode(9);
        // ListNode l2 =new ListNode(1,new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))))))))));

        ListNode l3 = Solution.addTwoNumbers(l1, l2);
        ListNode b1 = l3;
        int a1 = b1.val;
        ListNode b2 = l3.next;
        int a2 = b2.val;
        ListNode b3 = b2.next;
        int a3 = b3.val;
        System.out.println("val=" + a1 + " " + a2 + " " + a3 + " ");
    }

    public static class ListNode {
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

    class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            ListNode res2 = res;
            int cur = 0;
            while (l1 != null || l2 != null || cur != 0) {
                int x, y;
                if (l1 != null) {
                    x = l1.val;
                } else {
                    x = 0;
                }
                if (l2 != null) {
                    y = l2.val;
                } else {
                    y = 0;
                }

                int sum = cur + x + y;
                cur = sum / 10;
                res2.next = new ListNode(sum % 10);
                res2 = res2.next;
                System.out.println("sum=" + sum + " k=" + " a.val=" + res2.val);

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            return res.next;
        }
    }
}
