package com.adeng.leetcode.dp.middle;

/**
 * 322. 零钱兑换
 * <p>
 * https://leetcode.cn/problems/coin-change/description/
 * <p>
 * 思路：
 * 1.
 */
public class test_322 {

    public int coinChange(int[] coins, int amount) {

        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        // 初始化
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }

        dp[0] = 0;

        // 遍历物品
        for (int i = 0; i < coins.length; i++) {
            // 遍历背包
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 :dp[amount];
    }
}
