package com.adeng.leetcode.greedy.simple;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode.cn/problems/assign-cookies/description/
 * <p>
 * 思路：
 */
public class test_455 {

    // 目标：满足更多孩子，并且 g 的和要大
    public int findContentChildren(int[] g/*人的胃口*/, int[] s/*食物*/) {

        Arrays.sort(g);
        Arrays.sort(s);

        int num = 0;
        int sum = 0;
        int startGIndex = g.length - 1;

        // 遍历食物，从大的优先
        for (int sIndex = s.length - 1; sIndex >= 0; sIndex--) {
            for (int gIndex = startGIndex; gIndex >= 0; gIndex--) {
                // 人 <= 食物
                if (g[gIndex] <= s[sIndex]) {
                    num++;
                    sum += g[gIndex];
                    startGIndex = gIndex - 1;
                    break;
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        test_455 test455 = new test_455();
        test455.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
    }

}
