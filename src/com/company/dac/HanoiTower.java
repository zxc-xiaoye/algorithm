package com.company.dac;

import sun.jvm.hotspot.utilities.CPPExpressions;

/**
 * @author xiaoye
 * @create 2020-08-23 20:41
 */
public class HanoiTower {
    static int count = 0;
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
        System.out.println(count);
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            count++;
            System.out.println("第1个盘从" + a + " -> " + c);
        } else {
            // 如果num 大于2， 总是可以看成是两个盘， 最下面一个盘， 上面所有盘
            // 1. 先把最上面的所有盘 A -> B, 移动过程会使用到 C
            hanoiTower(num - 1, a, c, b);
            // 2. 把最下面的盘 A -> C
            count++;
            System.out.println("第" + num + "个盘从" + a + " -> " + c);
            // 3. 把B塔的所有盘从 B -> C, 移动过程中使用到 A
            hanoiTower(num - 1, b, a, c);
        }
    }
}
