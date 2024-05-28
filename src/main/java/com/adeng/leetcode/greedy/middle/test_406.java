package com.adeng.leetcode.greedy.middle;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406. 根据身高重建队列
 * <p>
 * https://leetcode.cn/problems/queue-reconstruction-by-height/description/
 * <p>
 * 思路：
 * 1. 先按照 h 身高 进行排序
 * 2. 然后再根据 k 进行移动
 */
public class test_406 {

    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];   // a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
            return b[0] - a[0];   //b - a 是降序排列，在a[0] != b[0]，的狀況會根據h值降序排列
        });

        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p);   //Linkedlist.add(index, value)，會將value插入到指定index裡。
        }

        return que.toArray(new int[people.length][]);
    }

}
