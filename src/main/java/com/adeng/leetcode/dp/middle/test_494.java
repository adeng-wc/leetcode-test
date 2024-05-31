package com.adeng.leetcode.dp.middle;

import java.util.stream.IntStream;

/**
 * 494. 目标和
 * <p>
 * https://leetcode.cn/problems/target-sum/description/
 * <p>
 * 思路：
 * 1. 回溯算法会超时
 * 2. 如果是求多少种，那 递推公式就是  dp[j] += dp[j - nums[i]];
 */
public class test_494 {
    /*
        target
        sum

        left + right = sum
        left - right = target
        right = sum - left
        left - (sum - left) = target
        left = (target + sum) / 2
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = IntStream.of(nums).sum();

        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((target + sum) % 2 == 1) {
            return 0;
        }

        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[bagSize];
    }
}
