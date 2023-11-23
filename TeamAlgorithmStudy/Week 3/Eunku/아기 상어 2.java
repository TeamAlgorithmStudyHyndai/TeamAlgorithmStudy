import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] safe = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    que.offer(new Point(i, j));
                    visit[i][j] = true;
                }
            }
        }
        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int i = 0; i < dx.length; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= m) continue;
                if (!visit[x][y]) {
                    visit[x][y] = true;
                    safe[x][y] = safe[p.x][p.y] + 1;
                    que.offer(new Point(x, y));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, safe[i][j]);
            }
        }
        System.out.println(max);
    }
}

