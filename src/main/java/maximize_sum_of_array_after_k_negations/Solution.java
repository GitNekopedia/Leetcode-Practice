package maximize_sum_of_array_after_k_negations;

import java.util.Arrays;


class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(array, (a, b) -> Math.abs(b) - Math.abs(a));
        for (int i = 0; i < array.length && k > 0; i++) {
            if (array[i] < 0){
                array[i] = -array[i];
                k--;
            }
        }
        if (k % 2 != 0){
            array[array.length - 1] = -array[array.length - 1];
        }
        return Arrays.stream(array).mapToInt(Integer::intValue).sum();
    }

}