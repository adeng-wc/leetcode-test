package com.adeng.leetcode.dp.middle;

/**
 * 279. 完全平方数
 * <p>
 * https://leetcode.cn/problems/perfect-squares/description/
 *
 * 思路：
 * 1. dp[j]：和为j的完全平方数的最小数量为 dp[j]
 * 2. dp[j] = min(dp[j], dp[j-i*i])
 * 3. 数组初始化为 max，dp[0]=0
 *
 */
public class test_279 {

    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }

        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        return dp[n];
    }
}
