package com.adeng.leetcode.backtracking.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * <p>
 * https://leetcode.cn/problems/combination-sum-iii/description/
 * <p>
 * 思路：
 * 1. 回溯算法
 */
public class test_216 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1);
        return result;
    }

    public void backTracking(int k, int n, int startIndex) {
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 剪枝
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;

            backTracking(k, n, i + 1);

            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
