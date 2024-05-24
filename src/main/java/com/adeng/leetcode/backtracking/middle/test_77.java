package com.adeng.leetcode.backtracking.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合（不强调元素顺序）
 * <p>
 * https://leetcode.cn/problems/combinations/description/
 *
 * 思路：
 * 1. 回溯算法，穷举
 * 2. 增加剪枝逻辑
 */
public class test_77 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(1, n, k);
        return result;
    }

    private void backTracking(int startIndex, int n, int k) {
        // 退出条件
        if (subList.size() == k) {
            result.add(new ArrayList<>(subList));
            return;
        }

        // 可以剪枝的地方就在递归中每一层for循环所选择的起始位置
        // 当剩余个数，不足 (k-subList.size()) 的时候，就可以停止遍历
        for (int i = startIndex; i <= n-(k-subList.size())+1; i++) {
            subList.add(i);
            backTracking(i + 1, n, k);
            subList.removeLast();
        }
    }

    public static void main(String[] args) {
        test_77 t = new test_77();
        List<List<Integer>> combine = t.combine(4, 2);
    }
}
