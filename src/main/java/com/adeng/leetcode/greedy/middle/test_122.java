package com.adeng.leetcode.greedy.middle;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 * <p>
 * 思路：
 * 1. 计算出每一天的利润，然后选正数，进行累加
 */
public class test_122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(prices[i] - prices[i - 1], 0);
        }
        return sum;
    }
}
