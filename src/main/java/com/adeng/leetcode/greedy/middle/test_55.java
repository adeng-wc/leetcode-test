package com.adeng.leetcode.greedy.middle;

/**
 * 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game/description/
 * <p>
 * 思路：
 * 1. 用回溯算法会超时
 * 2. 直接用步长范围来判断
 */
public class test_55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return true;
        }

        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            if (cover >= nums.length - 1) {
                return true;
            }
            cover = Math.max(cover, i + nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        test_55 test55 = new test_55();
        test55.canJump(new int[]{2,0,0});

    }
}
