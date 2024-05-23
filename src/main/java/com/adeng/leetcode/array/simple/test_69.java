package com.adeng.leetcode.array.simple;

/**
 * 69. x 的平方根
 * <p>
 * https://leetcode.cn/problems/sqrtx/description/
 *
 * 思路：从中间取值判断
 */
public class test_69 {

    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
                ans = mid;
            }
        }

        return ans;
    }
}
