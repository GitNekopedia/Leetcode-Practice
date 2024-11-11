package com.leetcode.intersection;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }

        curA = headA;
        curB = headB;
        if (lenA > lenB) {
            for (int i = 0; i <= lenA - lenB; i++) {
                curA = curA.next;

            }
        } else {
            for (int i = 0; i <= lenB - lenA; i++) {
                curB = curB.next;
            }
        }

        while (curA.next != null && curB.next != null) {

            curA = curA.next;
            curB = curB.next;
            if (curA == curB) {
                break;
            }
            if (curA.next == null || curB.next == null) return null;
        }
        if (lenA > lenB) return curA;
        else return curB;



    }
}