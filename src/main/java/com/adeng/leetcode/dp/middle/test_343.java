package com.adeng.leetcode.dp.middle;

/**
 * 343. 整数拆分
 * <p>
 * https://leetcode.cn/problems/integer-break/description/
 * <p>
 * 思路：
 * 1. dp[i]， i 进行拆分，得到的最大数组的乘积
 * 2. dp[i] = j * (i - j)
 * 3. dp[i] = j * dp[i - j]
 */
public class test_343 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

}
