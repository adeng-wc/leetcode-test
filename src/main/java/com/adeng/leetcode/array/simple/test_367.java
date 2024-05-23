package com.adeng.leetcode.array.simple;

/**
 * 367. 有效的完全平方数
 * <p>
 * https://leetcode.cn/problems/valid-perfect-square/description/
 *
 * 思路：还是从中间取
 */
public class test_367 {

    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid > num) {
                r = mid - 1;
            } else if ((long) mid * mid < num) {
                l = mid + 1;
                ans = mid;
            } else {
                return true;
            }
        }

        return false;
    }
}
