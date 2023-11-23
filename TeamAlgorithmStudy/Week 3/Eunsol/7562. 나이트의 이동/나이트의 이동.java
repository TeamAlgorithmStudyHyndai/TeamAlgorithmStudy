import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] arr;
    //상하좌우 및 대각선으로 1칸 또는 2칸씩 이동
   // static int[] moveX = {1, -1, 2, -2, 1, -1, 2, -2};
    //static int[] moveY = {1, -1, 1, -1, 2, -2, -2, 2};
    
    // 상하좌우로 1칸 또는 2칸, 대각선으로 1칸 또는 2칸 이동
    static int[] moveX = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] moveY = {-1, 1, -2, 2, -2, 2, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        Main ma = new Main();
        for (int i = 0; i < num; i++) {
            int l = sc.nextInt();
            arr = new int[l][l];
            visited = new boolean[l][l];

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            visited[x1][y1] = true;
            ma.BFS(x1, y1, x2, y2);

            //도착지점 출력
            System.out.println(arr[x2][y2]);
        }
    }

    public void BFS(int x, int y, int targetX, int targetY) {
        Queue<Spot> q = new LinkedList<>();
        q.add(new Spot(x, y));

        while (!q.isEmpty()) {
            Spot s = q.poll();

            //상하좌우 대각선 2칸씩 총 8개
            for (int i = 0; i < 8; i++) {
                int nextX = s.x + moveX[i];
                int nextY = s.y + moveY[i];

                if (nextX < 0 || nextY < 0 || nextX >= arr.length || nextY >= arr[0].length)
                    continue;
                if (visited[nextX][nextY] || arr[nextX][nextY] != 0)
                    continue;

                //새로운 좌표 큐에 더하기
                q.add(new Spot(nextX, nextY));
                arr[nextX][nextY] = arr[s.x][s.y] + 1;
                visited[nextX][nextY] = true;

                // 도착 지점에 도달했을 때 종료
                if (nextX == targetX && nextY == targetY) {
                    return;
                }
            }
        }
    }
}

class Spot {
    int x;
    int y;

    Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

