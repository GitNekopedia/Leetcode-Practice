package maxSlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        // 输出：[3,3,5,5,6,7]

        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        // 初始化
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] res = new int[n - k + 1];
        res[0] = nums[deque.peekFirst()];
        // 遍历剩余的数组
        for (int i = k; i < nums.length; i++) {
            // 1.把新的数索引加进队列 保证队列单调递减 头最大
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            // 2.队列头超出窗口范围则丢掉 头是1 i=4就要把它丢掉
            while (deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        System.out.println(Arrays.toString(res));
        return res;

    }


        public static void main (String[]args){
            int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
            maxSlidingWindow(nums, 3);

        }
    }

