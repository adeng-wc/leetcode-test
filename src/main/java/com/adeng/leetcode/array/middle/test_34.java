package com.adeng.leetcode.array.middle;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * 思路：
 * 1. 二分查找，找到中间的值
 * 2. 然后分别往左右取值
 */
public class test_34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }

        // 闭区间
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                // 相等，可能有多个值，可能落在中间
                return getRange(nums, target, mid);
            }
        }

        return new int[]{-1, -1};
    }

    public int[] getRange(int[] nums, int target, int mid) {
        int left = mid;
        int right = mid;

        while (true) {
            boolean leftBk = false;
            if ((left - 1) >= 0 && nums[left - 1] == target) {
                left--;
            } else {
                leftBk = true;
            }

            boolean rightBk = false;
            if ((right + 1) <= nums.length - 1 && nums[right + 1] == target) {
                right++;
            } else {
                rightBk = true;
            }

            if (leftBk && rightBk) {
                break;
            }
        }

        return new int[]{left, right};
    }

}
