import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] height;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        height = new int[n][n];
        int max_height=0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                max_height = Math.max(max_height, height[i][j]);
            }
        }
        int ans =0;
        for (int i=0; i<max_height; i++){
            ans = Math.max(ans, solution(i, n));
        }
        System.out.println(ans);
    }

    public static int solution(int rain, int n) {
        visited = new boolean[n][n];
        int answer = 0;
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (height[i][j] > rain && !visited[i][j]) {
                    answer++;
                    que.offer(new Point(i, j));

                    while (!que.isEmpty()) {
                        Point p = que.poll();
                        for (int k = 0; k < 4; k++) {
                            if (p.x + dx[k] >= 0 && p.x + dx[k] < n && p.y + dy[k] >= 0 && p.y + dy[k] < n) {
                                if (!visited[p.x + dx[k]][p.y + dy[k]] && height[p.x + dx[k]][p.y + dy[k]] > rain) {
                                    visited[p.x + dx[k]][p.y + dy[k]] = true;
                                    que.offer(new Point(p.x + dx[k], p.y + dy[k]));
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
