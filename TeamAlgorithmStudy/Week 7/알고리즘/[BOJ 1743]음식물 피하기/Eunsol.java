
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int maxAreaCnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            arr[X][Y] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    maxAreaCnt = Math.max(maxAreaCnt, BFS(i, j));
                }
            }
        }

        System.out.println(maxAreaCnt);
    }

    public static int BFS(int x, int y) {
        int cnt = 1; 
        Queue<PSpot> q = new LinkedList<>();
        q.add(new PSpot(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            PSpot ps = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = ps.x + dx[i];
                int nextY = ps.y + dy[i];

                if (nextX < 1 || nextY < 1 || nextX > arr.length - 1 || nextY > arr[0].length - 1)
                    continue;
                if (visited[nextX][nextY] || arr[nextX][nextY] == 0)
                    continue;

                visited[nextX][nextY] = true;
                q.add(new PSpot(nextX, nextY)); // z 값을 증가시키는 것이 아니라 1로 설정
                cnt++; 
            }
        }

        return cnt;
    }
}

class PSpot {
    int x;
    int y;
   

    public PSpot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
