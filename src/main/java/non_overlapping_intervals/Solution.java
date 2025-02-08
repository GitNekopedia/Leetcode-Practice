package non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
         * 思路：找出最大的不重叠数量，总数-最大不重叠数量 = 最少需要删除的数量
         * 根据右边界进行排序，然后遍历，如果左边界大于前一个的有边界则不重叠，count++
         * */
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int right = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= right){
                count++;
                right = interval[1];
            }
        }
        return intervals.length - count;
    }
}