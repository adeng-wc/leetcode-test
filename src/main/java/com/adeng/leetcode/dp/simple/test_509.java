package com.adeng.leetcode.dp.simple;

/**
 * 509. 斐波那契数
 * <p>
 * https://leetcode.cn/problems/fibonacci-number/description/
 */
public class test_509 {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int f_n_1 = 1;
        int f_n_2 = 0;
        int f_n = 0;
        for (int i = 1; i < n; i++) {
            f_n = f_n_1 + f_n_2;

            f_n_2 = f_n_1;
            f_n_1 = f_n;
        }

        return f_n;
    }
}
