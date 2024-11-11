package topKFrequent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            int[] tmp = new int[2];
            tmp[0] = integerIntegerEntry.getKey();
            tmp[1] = integerIntegerEntry.getValue();
            pq.add(tmp);
            if (pq.size() > k){
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
           res[i] = pq.poll()[1];
        }
        return res;



    }

    public static void main(String[] args) {
        int[] ints = {1,1,1,2,2,3};
        topKFrequent(ints, 2);
    }
}