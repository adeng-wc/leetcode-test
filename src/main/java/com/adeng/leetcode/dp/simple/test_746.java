package com.adeng.leetcode.dp.simple;

/**
 * 746. 使用最小花费爬楼梯
 * <p>
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 * <p>
 * 思路：
 * 1. dp + cost
 */
public class test_746 {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[len];
    }
}
