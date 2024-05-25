package com.adeng.leetcode.backtracking.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/description/
 */
public class test_39 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target, 0);
        return result;
    }

    private void backTracking(int[] candidates, int target, int startIndex) {
        // 退出条件
        if (sum == target) {
            // 题目中还需要考虑去重
            result.add(new ArrayList<>(pathList));
            return;
        } else if (sum > target) {
            return;
        }

        // 循环，题目中要求数字无限制重复
        // 因为是组合，以 [2 5 3]为例，中间分支从5开始就行
        // 剪枝
        for (int i = startIndex; i < candidates.length; i++) {
            pathList.add(candidates[i]);
            sum += candidates[i];
            // i + 1 和 i 的区别
            backTracking(candidates, target, i);
            pathList.remove(pathList.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        test_39 test39 = new test_39();

        test39.combinationSum(new int[]{8, 7, 4, 3}, 11);
    }
}
