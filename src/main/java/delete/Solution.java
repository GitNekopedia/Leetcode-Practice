package com.leetcode.delete;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0,head);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        //快指针要比慢指针多走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}



