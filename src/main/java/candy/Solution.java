package candy;

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        if (length == 0){
            return 0;
        }
        int[] candies = new int[length];
        Arrays.fill(candies,1);
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1] ){
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1) ;
            }
        }
        return Arrays.stream(candies).sum();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ratings = {1, 2, 2};
        int candy = solution.candy(ratings);
        System.out.println(candy);
    }
}