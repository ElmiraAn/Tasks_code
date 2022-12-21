public class RemoveNthNodeFromEndofList_19 {
    /*
    Учитывая headсвязанный список, удалите узел из конца списка и верните его голову
    Ввод: голова = [1,2,3,4,5], n = 2
    Вывод: [1,2,3,5]
     */
    public static void main(String[] params) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n =5 ;
        ListNode res = removeNthFromEnd(head,n);
        ListNode b1 = res;
        int a1 = b1.val;
        ListNode b2 = res.next;
        int a2 = b2.val;
        ListNode b3 = b2.next;
        int a3 = b3.val;
        ListNode b4 = b3.next;
        int a4 = b4.val;
        //ListNode b5 = b4.next;
        //int a5 = b5.val;
        System.out.println("val=" + a1 + " " + a2 + " " + a3 + " "+a4+" ");
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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        ListNode res2 = head;
        for (int i=0; i<n; i++){
            res = res.next;
        }
        if (res==null) return head.next;
        while (res.next!=null){
            res = res.next;
            res2=res2.next;
        }
        res2.next = res2.next.next;
        return head;
    }
}

