package wiggle_subsequence;

class Solution {
    public int wiggleMaxLength(int[] nums) {

        int length = nums.length;
        if (length < 2){
            return length;
        }

        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && preDiff <= 0 )|| (diff < 0 && preDiff >= 0)){
                count++;
                preDiff = diff;
            }
        }
        return count;

    }
}