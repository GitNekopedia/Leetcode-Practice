package com.leetcode.reverse;

public class Test {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5,null);
        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);

        ListNode head = swapPairs(n1);
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
        System.out.println(head.next.next.next.next.val);




    }
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        while(cur.next!=null && cur.next.next!=null){
            ListNode temp = cur.next;
            ListNode temp1 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = temp;
            cur.next.next.next = temp1;
            cur = cur.next.next;
            cur.next = temp1;

        }
        return dummyHead.next;

    }
}
