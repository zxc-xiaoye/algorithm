package com.company.kruskal;


import java.util.Arrays;

/**
 * @author xiaoye
 * @create 2020-08-29 22:18
 */
public class KruskalAlgorithm {

    private static char[] vertexs;

    private static int[][] matrix;

    private static int edgeNum = 0;

    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        vertexs = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        matrix = new int[][]{
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0},
        };
        init();
        System.out.println(edgeNum);
        Edge[] edges = getEdges();
        sortEdge(edges);
        Edge[] kruskal = kruskal(edges);
        System.out.println(Arrays.toString(kruskal));

    }

    private static Edge[] kruskal(Edge[] edges) {
        Edge[] result = new Edge[vertexs.length - 1];
        int index = 0;
        int[] ends = new int[edgeNum];
        for (Edge edge : edges) {
            int startIndex = getPosition(edge.getStart());
            int endIndex = getPosition(edge.getEnd());

            int m = getEnd(ends, startIndex);
            int n = getEnd(ends, endIndex);
            if (m != n) {
                // 没构成回路
                // 精华！！！ m的终点设置为n n不需要设置终点
                ends[m] = n;
                result[index++] = edge;
            }
        }
        return result;
    }

    /**
     * 精华！！！
     * 获取下标为i的顶点所对应的终点下标
     * @param ends 终点数组
     * @param i 顶点下标
     * @return 终点下标
     */
    private static int getEnd(int[] ends, int i){
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    private static Edge[] getEdges() {
        Edge[] edges = new Edge[edgeNum];
        int index = 0;
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new Edge(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    private static void sortEdge(Edge[] edges) {
        Edge temp;
        for (int i = 0; i < edges.length - 1 ; i++) {
            for (int j = 0; j < edges.length - 1 -i; j++) {
                if (edges[j].getWeight() > edges[j+1].getWeight()) {
                    temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    private static int getPosition(char c) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == c) {
                return i;
            }
        }
        return -1;
    }

    private static void init() {
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }


}

