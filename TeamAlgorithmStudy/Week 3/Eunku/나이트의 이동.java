import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] map;
    static int[][] ans;

    static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            map = new boolean[size][size];
            ans = new int[size][size];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            Point start = new Point(start_x, start_y);
            Point end = new Point(end_x, end_y);
            System.out.println(DFS(start, end, size));
        }

    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int DFS(Point startP, Point endP, int size) {
        Queue<Point> que = new LinkedList<>();

        que.offer(startP);
        map[startP.x][startP.y] = true;
        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int i = 0; i < 8; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if (x < 0 || x >= size || y < 0 || y >= size) continue;

                if (!map[x][y] && ans[x][y] == 0) {
                    ans[x][y] = ans[p.x][p.y] + 1;
                    map[x][y] = true;
                    que.offer(new Point(x, y));
                }

            }
        }

        return ans[endP.x][endP.y];
    }
}
