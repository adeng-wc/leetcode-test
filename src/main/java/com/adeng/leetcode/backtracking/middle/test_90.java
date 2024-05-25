package com.adeng.leetcode.backtracking.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * <p>
 * https://leetcode.cn/problems/subsets-ii/description/
 */
public class test_90 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        backTracking(nums, used, 0);
        return result;
    }

    private void backTracking(int[] nums, int[] used, int startIndex) {
        // 无退出条件
        result.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            // 进行层级剪枝, 当 used[i - 1] == 0 的时候，才代表是同一树层
            if (i > 0 && used[i - 1] == 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            used[i] = 1;
            path.add(nums[i]);
            backTracking(nums, used, i + 1);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
