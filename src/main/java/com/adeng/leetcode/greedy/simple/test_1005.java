package com.adeng.leetcode.greedy.simple;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 1005. K 次取反后最大化的数组和
 * <p>
 * https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/
 * <p>
 * 思路：
 * 1. 使用优先级队列 (不是最优解)
 * 2.
 */
public class test_1005 {

    /**
     * 使用堆排序，性能不好
     *
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
        }

        for (int i = 0; i < k; i++) {
            Integer min = pq.poll();
            if (min != null) {
                pq.add(-min);
            }
        }

        return pq.stream().mapToInt(e -> e).sum();
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (k % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        test_1005 test1005 = new test_1005();

        test1005.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2);
    }

}
