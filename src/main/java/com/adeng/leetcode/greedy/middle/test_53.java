package com.adeng.leetcode.greedy.middle;

/**
 * 53. 最大子数组和
 * <p>
 * https://leetcode.cn/problems/maximum-subarray/description/
 * <p>
 * 思路：
 * 1. 累加的时候，和为负数，舍弃负数的部分
 */
public class test_53 {

    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            count += num;
            sum = Math.max(sum, count);
            if (count < 0) {
                count = 0;
            }
        }

        return sum;
    }

}
