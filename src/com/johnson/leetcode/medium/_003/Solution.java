package com.johnson.leetcode.medium._003;


public class Solution {

    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] intArray = new int[128];
        int sum = 0;
        int start = 0; // 窗口开始位置

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, intArray[index]);
            sum = Math.max(sum, i - start + 1);
            intArray[index] = i + 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        String ss = "ABEAABCE";
        Solution solution = new Solution();
        int len = solution.lengthOfLongestSubstring(ss);
        System.out.println(len);
    }
}
