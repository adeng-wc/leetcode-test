package com.adeng.leetcode.dp.middle;

/**
 * 01背包
 * <p>
 * https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-2.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 * <p>
 * 思路：
 * 1. 滚动数组，二维降一维；通过把 dp[i-1] 拷贝 到 dp[i] 上。
 * 1.1 i 是物品，j 是背包容量。dp[j] = 背包容量j的最大价值
 * 2. dp[j] = max(dp[j], dp[j - weight[i]] + value[i])
 * 3. 遍历顺序
 */
public class knapsack_problem_02 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        testWeightBagProblem(weight, value, bagWight);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++) {
            // 注意：这里是倒序。
            // 倒序是为了保证物品 i 只被放入一次。
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++) {
            System.out.print(dp[j] + " ");
        }
    }

}
