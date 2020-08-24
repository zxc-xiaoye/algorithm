package com.company.kmp;

/**
 * @author xiaoye
 * @create 2020-08-24 21:02
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "I LOVE CHINA!!!";
        String str2 = "LV";
        int i = violenceMatch(str1, str2);

    }

    /**
     * 暴力匹配
     * @param str1 原字符串
     * @param str2 待匹配字符串
     * @return 下标
     */
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;
        int j = 0;
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]){
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }
}
