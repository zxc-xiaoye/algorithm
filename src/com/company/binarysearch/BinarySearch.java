package com.company.binarysearch;

/**
 * @author xiaoye
 * @create 2020-08-23 18:36
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 33, 65, 78, 100};
        int i = binarySearch(arr, 100);
        System.out.println(i);
    }

    /**
     * 非递归的二分查找
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
