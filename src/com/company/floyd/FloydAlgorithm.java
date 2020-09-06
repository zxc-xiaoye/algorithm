package com.company.floyd;

import java.util.Arrays;

/**
 * @author xiaoye
 * @create 2020-09-06 19:58
 */
public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};

        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();
    }
}
class Graph {
    private char[] vertex;
    private int[][] dis; // 保存各顶点间的距离
    private int[][] pre; // 保存前驱结点

    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        // init pre 存放前驱顶点的下标
        for (int i = 0; i < length; i++){
            Arrays.fill(pre[i], i);
        }
    }

    public void show(){
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]] + "\t");
            }
            System.out.println();
            for (int i = 0; i < dis.length; i++) {
                System.out.print("[" + vertex[k] + " -> " + vertex[i] + " : " + dis[k][i] + "]\t");
            }
            System.out.println();
            System.out.println();
        }
    }

    public void floyd() {
        int len = 0;
        // k 为中间顶点下标
        for (int k = 0; k < dis.length; k++) {
            // 从i顶点开始出发
            for (int i = 0; i < dis.length; i++) {
                // j 为终点
                for (int j = 0; j < dis.length; j ++) {
                    len = dis[i][k] + dis[k][j];
                    // 如果i经过k到j的距离 小于i j的直连距离
                    if (len < dis[i][j]){
                        dis[i][j] = len; // 更新距离
                        pre[i][j] = pre[k][j]; // 更新前驱结点
                    }
                }
            }
        }
    }
}
