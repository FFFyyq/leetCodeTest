package mhy;

import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class QuantumSea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Point miPosition = new Point(scanner.nextInt(), scanner.nextInt());
        Point yuePosition = new Point(scanner.nextInt(), scanner.nextInt());
        Point ottoPosition = new Point(scanner.nextInt(), scanner.nextInt());

        int minSteps = findMinSteps(n, m, miPosition, yuePosition, ottoPosition);
        System.out.println(minSteps);
    }

    public static int findMinSteps(int n, int m, Point mi, Point yue, Point otto) {
        int[][] distance = new int[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];

        Queue<Point> queue = new LinkedList<>();
        queue.add(mi);
        visited[mi.x][mi.y] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == yue.x && current.y == yue.y) {
                return distance[current.x][current.y];
            }

            for (int i = 0; i < 4; i++) {
                int newX = (current.x + dx[i] + n) % n; // Handle wrapping around the edges
                int newY = (current.y + dy[i] + m) % m;

                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    distance[newX][newY] = distance[current.x][current.y] + 1;
                    queue.add(new Point(newX, newY));
                }
            }
        }

        return -1; // No path found
    }
}