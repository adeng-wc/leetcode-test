package com.adeng.leetcode.dp.middle;

/**
 * 474. 一和零
 * <p>
 * https://leetcode.cn/problems/ones-and-zeroes/description/
 * <p>
 * 思路：
 * 1. 01 背包问题(背包容量：m个0，n个1)
 * 1.1 定义：最多有 i个0 和 j个1 的 strs 的最大子集的大小为 dp[i][j]
 * 2. dp[i][j] = max(dp[i-x][j-y] + 1, dp[i][j])
 * 3.
 */
public class test_474 {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
