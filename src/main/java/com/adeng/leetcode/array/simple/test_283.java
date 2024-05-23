package com.adeng.leetcode.array.simple;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/description/
 *
 * 思路：
 * 1. 先用快慢指针
 * 2. 然后填充 0
 */
public class test_283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}
