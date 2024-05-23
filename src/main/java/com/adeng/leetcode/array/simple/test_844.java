package com.adeng.leetcode.array.simple;

/**
 * 844. 比较含退格的字符串
 * <p>
 * https://leetcode.cn/problems/backspace-string-compare/description/
 * <p>
 * 思路1：（不是最优解）
 * 1. 双指针，遇到 # 就回退
 * 2. 重新生成 string 在比较
 */
public class test_844 {

    public boolean backspaceCompare(String s, String t) {
        return getCharArray(s).equals(getCharArray(t));
    }

    private static String getCharArray(String str) {
        int slow = 0;
        StringBuilder sb = new StringBuilder();
        char[] strArray = str.toCharArray();

        for (int fast = 0; fast < str.length(); fast++) {
            char c = strArray[fast];
            if (c != '#') {
                sb.append(c);
                slow++;
            } else {
                if (slow > 0) {
                    sb.deleteCharAt(--slow);
                }
            }
        }

        return sb.toString();
    }
}
