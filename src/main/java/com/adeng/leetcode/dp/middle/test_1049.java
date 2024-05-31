package com.adeng.leetcode.dp.middle;

import java.util.stream.IntStream;

/**
 * 1049. 最后一块石头的重量 II
 * <p>
 * https://leetcode.cn/problems/last-stone-weight-ii/description/
 * 思路：
 * 1. 分重量总和接近的2堆，然后相减，就变成 01背包 问题
 * 2.
 */
public class test_1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = IntStream.of(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[target];
    }
}
