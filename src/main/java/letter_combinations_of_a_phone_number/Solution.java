package letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty() || digits == null){
            return result;
        }

        // 数字映射到字母
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        // 开始回溯
        backtrack(0, new StringBuilder(), digits, result, phoneMap);

        return result;
    }

    private static void backtrack(int index, StringBuilder path, String digits, List<String> result, Map<Character, String> phoneMap) {
        // 如果当前路径长度等于输入字符串长度，保存当前路径到结果
        if (path.length() == digits.length()){
            result.add(path.toString());
            return;
        }


        // example:输入"23"， 2 -》 abc， 3 -》 def， ad, ae, af,
        char c = digits.charAt(index);
        String letters = phoneMap.get(c);

        for (char letter: letters.toCharArray()){
            path.append(letter);
            backtrack(index + 1, path, digits, result, phoneMap);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}