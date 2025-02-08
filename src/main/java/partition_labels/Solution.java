package partition_labels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        /*
        * 思路：维护一个Map，记录每个字符最后出现的位置，
        * 然后遍历字符串，如果当前字符最后出现的位置大于当前的end，则更新end
        * 确保当前片段的字符串都包含在当前片段中
        * */
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer curEnd = map.get(s.charAt(i));
            end = Math.max(end, curEnd);
            if (i == end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}