

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] arr;
    static int[][][] distance; // 벽을 부순 상태에 따른 거리를 기록
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        arr = new int[N][M];
        distance = new int[N][M][2]; // 벽을 부순 상태에 따른 거리를 저장

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    public static int bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, 1, 0)); // 시작 지점과 벽 부숨 횟수를 함께 저장
        distance[startX][startY][0] = 1; // 시작 지점의 거리를 기록

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                return distance[current.x][current.y][current.wallBroken];
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 0 && distance[nx][ny][current.wallBroken] == 0) {
                        distance[nx][ny][current.wallBroken] = distance[current.x][current.y][current.wallBroken] + 1;
                        queue.offer(new Point(nx, ny, current.distance + 1, current.wallBroken));
                    } else if (current.wallBroken == 0 && arr[nx][ny] == 1 && distance[nx][ny][1] == 0) {
                        distance[nx][ny][1] = distance[current.x][current.y][current.wallBroken] + 1;
                        queue.offer(new Point(nx, ny, current.distance + 1, 1)); // 벽을 부수고 이동한 경우를 기록
                    }
                }
            }
        }

        return -1; // 도착점에 도달할 수 없는 경우
    }

    static class Point {
        int x, y, distance, wallBroken;

        Point(int x, int y, int distance, int wallBroken) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.wallBroken = wallBroken;
        }
    }
}
