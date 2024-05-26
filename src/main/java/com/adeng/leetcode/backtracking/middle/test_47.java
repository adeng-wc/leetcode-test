package com.adeng.leetcode.backtracking.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * <p>
 * https://leetcode.cn/problems/permutations-ii/description/
 */
public class test_47 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        backTracking(nums, used);
        return result;
    }

    private void backTracking(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }

            if (i > 0 && used[i - 1] == 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            used[i] = 1;
            path.add(nums[i]);
            backTracking(nums, used);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
