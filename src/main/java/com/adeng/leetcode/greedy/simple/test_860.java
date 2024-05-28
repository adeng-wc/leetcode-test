package com.adeng.leetcode.greedy.simple;

/**
 * 860. 柠檬水找零
 * <p>
 * https://leetcode.cn/problems/lemonade-change/description/
 * <p>
 * 思路：
 * 1.
 */
public class test_860 {


    public boolean lemonadeChange(int[] bills) {
        // 只会出现 5，10，20
        int five = 0;
        int ten = 0;
        for (int i : bills) {
            if (i == 5) {
                five++;
            } else if (i == 10) {
                ten++;
                if (five == 0) {
                    return false;
                }
                five--;
            } else if (i == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (ten == 0 && five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            } else {
                // 数据异常
                return false;
            }
        }

        return true;
    }
}
