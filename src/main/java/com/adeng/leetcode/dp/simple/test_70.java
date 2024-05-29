package com.adeng.leetcode.dp.simple;

/**
 * 70. 爬楼梯
 * <p>
 * https://leetcode.cn/problems/climbing-stairs/description/
 * <p>
 * 思路：
 * 1. 分析递推公式
 */
public class test_70 {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int dp_1 = 1;
        int dp_2 = 2;

        int dp = 0;
        for (int i = 2; i < n; i++) {
            dp = dp_1 + dp_2;

            dp_1 = dp_2;
            dp_2 = dp;
        }

        return dp;
    }
}
