package com.adeng.leetcode.array.simple;

/**
 * 26. 删除有序数组中的重复项
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 * <p>
 * 思路：快慢指针
 */
public class test_26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow + 1;
    }
}
