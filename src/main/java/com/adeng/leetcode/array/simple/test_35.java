package com.adeng.leetcode.array.simple;

/**
 * 35. 搜索插入位置
 * <p>
 * https://leetcode.cn/problems/search-insert-position/description/
 *
 * 二分查找思路
 */
public class test_35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 闭区间 [left,rifht]
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        if (nums[left] > target) {
            return 0;
        }

        if (nums[right] < target) {
            return nums.length;
        }

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                // 匹配到
                return mid;
            }
        }

        // 没匹配到
        return right + 1;
    }
}
