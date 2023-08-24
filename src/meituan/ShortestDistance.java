package meituan;

import java.util.Scanner;

public class ShortestDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] distances = new int[n];
        for (int i = 0; i < n-1; i++) {
            distances[i] = scanner.nextInt();
        }
        distances[n-1] = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int totalDistance = calculateTotalDistance(distances);
        int distanceFromXToY = calculateDistanceFromXToY(distances, x, y);

        int shortestDistance = Math.min(distanceFromXToY, totalDistance - distanceFromXToY);
        System.out.println(shortestDistance);
    }

    private static int calculateTotalDistance(int[] distances) {
        int totalDistance = 0;
        for (int distance : distances) {
            totalDistance += distance;
        }
        return totalDistance;
    }

    private static int calculateDistanceFromXToY(int[] distances, int x, int y) {
        int distanceFromXToY = 0;
        if (x < y) {
            for (int i = x; i < y; i++) {
                distanceFromXToY += distances[i-1];
            }
        } else {
            for (int i = y; i < x; i++) {
                distanceFromXToY += distances[i-1];
            }
        }
        return distanceFromXToY;
    }
}
