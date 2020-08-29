package com.company.prim;


/**
 * @author xiaoye
 * @create 2020-08-29 20:16
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},
        };

        MGraph graph = new MGraph(verxs);
        createGraph(graph, verxs, data, weight);
        showGraph(graph);

        prim(graph, 0);
    }

    public static void prim(MGraph graph, int start) {

        int[] visited = new int[graph.verxs];
        // 把开始结点设置为已访问
        visited[start] = 1;

        int minWeight;
        int pre = -1;
        int post = -1;
        // 只需遍历verxs - 1次
        for (int k = 0; k < graph.verxs - 1; k++) {
            minWeight = 10000;

            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        pre = i;
                        post = j;
                    }
                }
            }
            visited[post] = 1;
            System.out.println(graph.data[pre] + "->" + graph.data[post] + " : " + graph.weight[pre][post]);
        }
    }

    public static void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        for (int i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public static void showGraph(MGraph graph) {
        for (int i = 0; i < graph.verxs; i++) {
            for (int j = 0; j<graph.verxs; j ++) {
                System.out.print(graph.weight[i][j] + "\t");
            }
            System.out.println();
        }
    }

}

class MGraph{
    int verxs;
    char[] data;
    int[][] weight;

    public MGraph(int verxs){
        this.verxs = verxs;
        this.data = new char[verxs];
        this.weight = new int[verxs][verxs];
    }
}
