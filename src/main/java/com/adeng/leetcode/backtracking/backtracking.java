/**
 * 回溯算法
 * <p>
 * 回溯算法本质是 _穷举_，只能通过 _剪枝_ 来优化。
 * <p>
 * 解决的问题：
 * 1. 组合问题：N个数里面按一定规则找出k个数的集合
 * 2. 切割问题：一个字符串按一定规则有几种切割方式
 * 3. 子集问题：一个N个数的集合里有多少符合条件的子集
 * 4. 排列问题：N个数按一定规则全排列，有几种排列方式
 * 5. 棋盘问题：N皇后，解数独等
 *
 * 回溯三部曲:
 * 1. 回溯函数模板返回值以及参数
 * 2. 回溯函数终止条件
 * 3. 回溯搜索的遍历过程
 *
 * 模板：
 *
 * void backtracking(参数) {
 *     if (终止条件) {
 *         存放结果;
 *         return;
 *     }
 *
 *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
 *         处理节点;
 *         backtracking(路径，选择列表); // 递归
 *         回溯，撤销处理结果
 *     }
 * }
 */
package com.adeng.leetcode.backtracking;

