package com.company.kruskal;


/**
 * @author xiaoye
 * @create 2020-09-09 21:19
 */
public class Edge {

    private char start;
    private char end;
    private int weight;

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" + start +
                " -> " + end +
                " : " + weight +
                '}';
    }

    public char getStart() {
        return start;
    }

    public char getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }
}
