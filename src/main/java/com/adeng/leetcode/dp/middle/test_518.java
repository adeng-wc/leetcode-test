package com.adeng.leetcode.dp.middle;

/**
 * 518. 零钱兑换 II
 * <p>
 * https://leetcode.cn/problems/coin-change-ii/description/
 * <p>
 * 思路：
 * 1. 完全背包
 * 2. dp[j] 装满背包 j ，有 dp[j] 种方法。
 * 3. dp[j] += dp[j - coins[j]]
 * 4. 遍历顺序，先物品再背包
 */
public class test_518 {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

}
