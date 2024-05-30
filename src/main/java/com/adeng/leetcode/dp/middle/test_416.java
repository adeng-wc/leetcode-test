package com.adeng.leetcode.dp.middle;

import java.util.stream.IntStream;

/**
 * 416. 分割等和子集
 * <p>
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 * <p>
 * 思路：
 * 1. 回溯算法 暴力搜索 会超时
 * 2. 抽象成 01背包问题。
 * 3.
 */
public class test_416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int sum = IntStream.of(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        // 先遍历物品，再遍历背包
        for (int i = 0; i < nums.length; i++) {
            // j 是背包的容量，nums[i] 是物品i的容量，必须要大于才有意义
            for (int j = target; j >= nums[i]; j--) {
                // 01背包的递推公式为：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
                // 所以递推公式：dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }

            // 剪枝
            if (dp[target] == target)
                return true;
        }

        return dp[target] == target;
    }

    public static void main(String[] args) {
        test_416 test416 = new test_416();
        test416.canPartition(new int[]{14,9,8,4,3,2});
    }
}
