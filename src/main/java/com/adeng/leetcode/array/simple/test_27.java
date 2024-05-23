package com.adeng.leetcode.array.simple;

/**
 * 27. 移除元素
 * <p>
 * https://leetcode.cn/problems/remove-element/description/
 * <p>
 * 思路：快慢指针
 */
public class test_27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        for (int q = 0; q < nums.length; q++) {
            if (nums[q] != val) {
                nums[slow++] = nums[q];
            }
        }

        return slow;
    }
}
