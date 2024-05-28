package com.adeng.leetcode.greedy.middle;

/**
 * 134. 加油站
 * <p>
 * https://leetcode.cn/problems/gas-station/description/
 * <p>
 * 思路：
 * 1. =暴力，两个 for 循环，代码比较复杂
 * 2.
 */
public class test_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 每步的剩余油量
        int curSum = 0;
        // 总的剩余油量
        int totalSum = 0;
        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];

            if (curSum < 0) {
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }

        // 综合如果小于 0 ，那一定不存在。
        if (totalSum < 0) return -1;
        return index;
    }

}
