package com.adeng.leetcode.dp.middle;

/**
 * 96. 不同的二叉搜索树
 * <p>
 * https://leetcode.cn/problems/unique-binary-search-trees/description/
 * 思路：
 * 1. 二叉搜索树，会有大小排序
 * 2. dp[i]，1到i为节点组成的二叉搜索树的个数为dp[i]
 * 2.1 以 i 为头节点的二叉树 = dp[j-1] * dp[i-j]
 * 2.2 dp[i] 代表所有的累加。
 * 3. dp[i] += dp[j-1] * dp[i-j]
 */
public class test_96 {

    /*
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5; (元素1头结点 +  元素2头结点 + 元素3头结点)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

}
