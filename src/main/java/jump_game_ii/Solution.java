package jump_game_ii;
class Solution {
    public int canJump(int[] nums) {
        int step = 0;
        int currentEnd = 0;
        int len = nums.length;
        int maxReach = 0;
        if (len == 1){
            return 0;
        }
        for (int i = 0; i < len; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= len -1){
                return ++step;
            }
            if (i == currentEnd){
                step++;
                currentEnd = maxReach;
            }
        }
        return -1;
    }
}