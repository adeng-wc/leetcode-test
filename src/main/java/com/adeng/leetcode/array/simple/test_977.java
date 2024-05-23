package com.adeng.leetcode.array.simple;

/**
 * 977. 有序数组的平方
 * <p>
 * https://leetcode.cn/problems/squares-of-a-sorted-array/description/
 *
 * 思路：
 * 1. 重新定义一个数组
 * 2. 因为有负数，所以首尾比较，大的插入新数组末尾
 */
public class test_977 {

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] result = new int[nums.length];
        int k = result.length - 1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[k--] = nums[left] * nums[left];
                left++;
            } else {
                result[k--] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }

}
