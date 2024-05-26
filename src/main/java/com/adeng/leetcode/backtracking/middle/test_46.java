package com.adeng.leetcode.backtracking.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode.cn/problems/permutations/description/
 * <p>
 * 思路：每个上下链路都是使用所有的元素。
 */
public class test_46 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        backTracking(nums, used);
        return result;
    }

    private void backTracking(int[] nums, int[] used) {
        // 数组用完，则退出
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 每层都要从头开始遍历，
        for (int i = 0; i < nums.length; i++) {
            // 表示上层已经使用了
            if (used[i] == 1) {
                continue;
            }

            used[i] = 1;
            path.add(nums[i]);
            backTracking(nums, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
