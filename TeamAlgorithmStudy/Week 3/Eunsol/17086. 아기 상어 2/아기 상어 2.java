

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    static int[][] arr;
    static boolean[][] visited;
    //대각선거리 1까지의 좌표
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	arr[i][j] = sc.nextInt();
            }
        }

        int maxResult = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    visited = new boolean[N][M];
                    maxResult = Math.max(maxResult, bfs(new PointSpot(i, j)));
                }
            }
        }

        System.out.println(maxResult);
    }

    static int bfs(PointSpot start) {
        Queue<PointSpot> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                PointSpot p = queue.poll();

                for (int i = 0; i < 8; i++) {
                    int nextX = p.x + dx[i];
                    int nextY = p.y + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length)
                        continue;
                    if (visited[nextX][nextY])
                        continue;
                    visited[nextX][nextY] = true;

                    //상어를 만난 경우
                    if (arr[nextX][nextY] == 1) {
                        return distance + 1;
                    }

                    queue.add(new PointSpot(nextX, nextY));
                }
            }
            //거리 증가 시키기
            distance++;
        }

        return 0;
    }
}
class PointSpot {
    int x;
    int y;

    public PointSpot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
