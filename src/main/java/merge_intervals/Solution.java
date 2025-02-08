package merge_intervals;

import javax.swing.plaf.ColorUIResource;
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= currentInterval[1]){
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                result.add(new int[]{currentInterval[0], currentInterval[1]});
                currentInterval = interval;
            }
        }
        result.add(currentInterval);
        return result.toArray(new int[result.size()][]);

    }
}