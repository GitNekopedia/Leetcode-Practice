package com.leetcode.ransomnote;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public static boolean canConstruct(String ransomNote, String magazine) {
        /*Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if (map.get(c) < 0){
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;*/

        // shortcut
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean b = canConstruct("a", "b");
        System.out.println(b);
    }
}