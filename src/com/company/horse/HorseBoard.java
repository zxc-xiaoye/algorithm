package com.company.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiaoye
 * @create 2020-09-06 20:50
 */
public class HorseBoard {

    private static int X;

    private static int Y;

    private static boolean[][] visited;

    private static boolean finished = false;


    public static void main(String[] args) {
        X = 6;
        Y = 6;
        int[][] board = new int[X][Y];
        visited = new boolean[X][Y];
        travel(board, 4, 3, 1);
        for (int[] item : board){
            System.out.println(Arrays.toString(item));
        }
    }

    public static void travel(int[][] board, int x, int y, int step) {
        board[x][y] = step;
        visited[x][y] = true;
        ArrayList<Point> next = next(new Point(x, y));
        sort(next);
        for (Point point : next) {
            if (!visited[point.x][point.y]){
                travel(board, point.x, point.y, step + 1);
            }
        }
        if (step < X * Y && !finished) {
            board[x][y] = 0;
            visited[x][y] = false;
        } else {
            finished = true;
        }

    }

    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> points = new ArrayList<>();
        Point point = new Point();
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 1) < X && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y + 1) < Y) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 2) < X && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y + 2) < Y) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 2) < X && (point.y = curPoint.y + 1) < Y) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 1) < X && (point.y = curPoint.y + 2) < Y) {
            points.add(new Point(point));
        }
        return points;
    }

    /**
     * 使用贪心算法优化
     * 对ps中所有的point的下一步的所有集合数目，进行非递减排序
     * @param ps
     */
    public static void sort(ArrayList<Point> ps) {
        ps.sort((o1, o2) ->{
            int count1 = next(o1).size();
            int count2 = next(o2).size();
            return Integer.compare(count1, count2);
        });
    }
}
