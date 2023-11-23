
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int M;
    static int N;
    static int K;
    static int[][] arr;
    //해당 좌표의 pair를 맞춰줘야 한다.
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};
    static int count = 1;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main ma = new Main();

        N = sc.nextInt();
        M = sc.nextInt();

        K = sc.nextInt();

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    arr[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	//0이거나 방문하지 않은 경우 BFS 탐색 시작
                if (arr[i][j] == 0 && !visited[i][j]) {
                    ma.BFS(i, j, 0);
                }
            }
        }

        //총 갯수
        System.out.println(ma.list.size());
        
        Integer[] sortedArr = list.toArray(new Integer[0]);
        Arrays.sort(sortedArr);
      
        for (int area : sortedArr) {
            System.out.print(area + " ");
        }
    }

    public void BFS(int x, int y, int z) {
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x, y, z));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + moveX[i];
                int nextY = p.y + moveY[i];

                //다음 index가 범위를 벗어나는 경우 continue
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                //값이 1이거나 이미 방문한 경우에는 더이상 add하지 않고 continue
                if (visited[nextX][nextY] || arr[nextX][nextY] == 1) {
                    continue;
                }

                q.add(new Point(nextX, nextY, z));
                visited[nextX][nextY] = true;
                //0로 이어진 영역 
                count++;
            }
        }
        //한번의 0으로 이어진 영역의 방문이 종료되었다면, list에 add한 후 1로 초기화
        list.add(count);
        count = 1;
    }
}

class Point {
    int x;
    int y;
    int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
