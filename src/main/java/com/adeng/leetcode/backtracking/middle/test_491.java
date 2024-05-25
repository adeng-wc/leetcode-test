package com.adeng.leetcode.backtracking.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 非递减子序列
 * <p>
 * https://leetcode.cn/problems/non-decreasing-subsequences/description/
 *
 * 注意：
 * 1. 同层树枝，要对已经遍历过的元素去重
 */
public class test_491 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTacking(nums, 0);
        return result;
    }

    private void backTacking(int[] nums, int startIndex) {
        // 退出条件 和 添加数组条件
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        // 需要记录同一树层使用过的元素，使用过就不能再使用
        Set<Integer> usedSet = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 树枝去重(同一父节点下本层重复使用的元素)
            if (usedSet.contains(nums[i])) {
                continue;
            }

            // 过滤条件(过滤掉后面小的内容)，递增
            if (path.size() > 0 && path.get(path.size() - 1) > nums[i]) {
                continue;
            }

            usedSet.add(nums[i]);
            path.add(nums[i]);
            backTacking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
