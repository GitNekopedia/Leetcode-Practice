package minimum_number_of_arrows_to_burst_balloons;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        /*
        * 思路：
        * 按右边界对气球排序，然后遍历气球，如果气球的左边界大于等于前一个气球的右边界，则可以用一支箭射穿，否则需要多一支箭。
        * */
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int arrowPos = points[0][1];
        for (int[] point : points) {
            if (point[0] > arrowPos){
                count++;
                arrowPos = point[1];
            }
        }
        return count;
    }
}