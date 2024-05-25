package com.adeng.leetcode.backtracking.middle;

import java.util.*;

/**
 * 40. 组合总和 II
 * <p>
 * https://leetcode.cn/problems/combination-sum-ii/description/
 * <p>
 * 注意：
 * 1. 需要去重（_树层去重_、树枝去重）
 */
public class test_40 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 树枝去重，需要对数组排序
        Arrays.sort(candidates);
        int[] used = new int[candidates.length];
        backTracking(candidates, target, 0, 0, used);
        return result;
    }

    private void backTracking(int[] candidates, int target, int startIndex, int sum, int[] used) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 剪枝
            if (sum + candidates[i] > target) {
                break;
            }

            // 树层去重
            // used[1,0,0]  used[0,1,0] 表示相同数字，不同位置
            if (i > 0 && used[i - 1] == 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }

            used[i] = 1;
            path.add(candidates[i]);
            backTracking(candidates, target, i + 1, sum + candidates[i], used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
