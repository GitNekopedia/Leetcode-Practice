package com.leetcode.reversestringII;

import javax.sound.sampled.ReverbType;

class Solution {
    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            if (i + k < ch.length) {
                reverse(ch, i, i + k - 1);
                continue;
            }
            reverse(ch, i, ch.length - 1);
            //abcdefgh
        }
        return new String(ch);
    }

    // 定义翻转函数
    public static void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }

    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        String s1 = reverseStr(s, 3);
        System.out.println(s1);
    }
}