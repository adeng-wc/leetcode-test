package com.adeng.leetcode.dp.middle;

/**
 * 62. 不同路径
 * https://leetcode.cn/problems/unique-paths/description/
 * 思路：
 * 1.
 */
public class test_62 {
    public int uniquePaths(int m, int n) {
        // 初始化
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // 遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
