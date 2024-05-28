package com.adeng.leetcode.greedy.middle;

/**
 * 45. 跳跃游戏 II
 * <p>
 * https://leetcode.cn/problems/jump-game-ii/description/
 * <p>
 * 思路：
 * 1. 还是用步长覆盖
 * 2. 求的是最小跳跃次数
 */
public class test_45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int count = 0;
        int curCover = 0;
        int maxCover = 0;

        for (int i = 0; i <= curCover; i++) {
            // 遇到更大的范围
            // 判断 是否 比最大值大
            if(i + nums[i] > maxCover){
                maxCover = Math.min(i + nums[i], nums.length - 1);
            }

            // 当前范围到末尾了，调到下一个范围
            if(i == curCover && maxCover > curCover){
                curCover = maxCover;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        test_45 test45 = new test_45();
        test45.jump(new int[]{2,3,1,1,4});
    }
}
