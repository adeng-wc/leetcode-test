package com.adeng.leetcode.greedy.middle;

/**
 * 376. 摆动序列
 * <p>
 * https://leetcode.cn/problems/wiggle-subsequence/description/
 * <p>
 * 思路：
 * 1. 子序列，可以通过删除不需要的元素
 * 2. 可能会出现单调增建、或者水平，这个时候要舍弃前面的
 */
public class test_376 {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        if (nums.length == 2) {
            if (nums[0] != nums[1]) {
                return 2;
            }
            return 1;
        }

        int subLength = 1;
        int status = 0;
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmp > nums[i]) {
                if (status >= 0) {
                    status = -1;
                    subLength++;
                    tmp = nums[i];
                } else {
                    // 单调了，删除不用的元素
                    tmp = nums[i];
                }
            } else if (tmp < nums[i]) {
                if (status <= 0) {
                    status = 1;
                    subLength++;
                    tmp = nums[i];
                } else {
                    // 单调了，删除不用的元素
                    tmp = nums[i];
                }
            }
            // 相等，删除不用的元素
        }

        return subLength;
    }

    public static void main(String[] args) {

        test_376 test_376 = new test_376();
        test_376.wiggleMaxLength(new int[]{33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72, 9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15});
    }
}
