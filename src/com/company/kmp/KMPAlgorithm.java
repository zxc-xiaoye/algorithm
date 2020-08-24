package com.company.kmp;

import java.util.Arrays;

/**
 * @author xiaoye
 * @create 2020-08-24 22:07
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABC";

        int[] next = kmpNext(str2);
        System.out.println(Arrays.toString(next));

        int i = kmpSearch(str1, str2, next);
        System.out.println("Index -> " + i);
    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {

            // kmp算法核心
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }


            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            if (j == str2.length()){
                return i + 1 - j; // 此时i还没i++，所以需要 +1 后减j
            }
        }
        return -1;
    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;

        for (int i = 1, j = 0; i < dest.length(); i++) {
            // kmp算法核心
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            // 当dest.chatAt(i) == dest.charAt(j)时， 部分匹配值就+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
