import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][][] arr;
    static int ans;
    static int[] count = {0, 4, 2, 4, 4, 1}; // 카메라번호당 회전수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[9][N][M];
        int temp = 0;
        ans = 0;
        int wall = 0;

        List<Point1> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                temp = Integer.parseInt(st.nextToken());
                arr[0][i][j] = temp;
                if (temp != 0 && temp != 6) list.add(new Point1(i, j, temp));
                if(temp ==6) wall++;
            }
        }
        dfs(list, 0);
        System.out.println(N*M-ans-wall);
    }

    public static void dfs(List<Point1> list, int depth) {
        if (depth == list.size()) {
            int sum =0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[list.size()][i][j] == -1) sum++;
                }
            }
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < count[list.get(depth).z]; i++) {

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    arr[depth + 1][j][k] = arr[depth][j][k];
                }
            }

            check(list.get(depth), depth + 1, i);
            dfs(list, depth + 1);
        }

    }

    public static void check(Point1 point1, int depth, int dir) {
        int x = point1.x;
        int y = point1.y;
        int z = point1.z;
        //1번 카메라일 때
        if (z == 1 && dir == 0) {
            upCheck(depth, x, y);
        } else if (z == 1 && dir == 1) {
            rightCheck(depth, x, y);
        } else if (z == 1 && dir == 2) {
            downCheck(depth, x, y);
        } else if (z == 1 && dir == 3) {
            leftCheck(depth, x, y);
        }
        //2번 카메라일 때
        if (z == 2 && dir == 0) {
            rightCheck(depth, x, y);
            leftCheck(depth, x, y);
        } else if (z == 2 && dir == 1) {
            upCheck(depth, x, y);
            downCheck(depth, x, y);
        }
        // 3번
        if (z == 3 && dir == 0) {
            upCheck(depth, x, y);
            rightCheck(depth, x, y);
        } else if (z == 3 && dir == 1) {
            rightCheck(depth, x, y);
            downCheck(depth, x, y);
        } else if (z == 3 && dir == 2) {
            downCheck(depth, x, y);
            leftCheck(depth, x, y);
        } else if (z == 3 && dir == 3) {
            leftCheck(depth, x, y);
            upCheck(depth, x, y);
        }
        // 4번
        if (z == 4 && dir == 0) {
            leftCheck(depth, x, y);
            upCheck(depth, x, y);
            rightCheck(depth, x, y);
        } else if (z == 4 && dir == 1) {
            upCheck(depth, x, y);
            rightCheck(depth, x, y);
            downCheck(depth, x, y);
        } else if (z == 4 && dir == 2) {
            rightCheck(depth, x, y);
            downCheck(depth, x, y);
            leftCheck(depth, x, y);
        } else if (z == 4 && dir == 3) {
            downCheck(depth, x, y);
            leftCheck(depth, x, y);
            upCheck(depth, x, y);
        }
        // 5번
        if (z == 5) {
            downCheck(depth, x, y);
            leftCheck(depth, x, y);
            rightCheck(depth, x, y);
            upCheck(depth, x, y);
        }
    }

    public static void rightCheck(int depth, int x, int y) {
        for (int i = y; i < M; i++) {
            if (arr[depth][x][i] == 6) break;
            arr[depth][x][i] = -1;
        }
    }

    public static void leftCheck(int depth, int x, int y) {
        for (int i = y; i >= 0; i--) {
            if (arr[depth][x][i] == 6) break;
            arr[depth][x][i] = -1;
        }
    }

    public static void upCheck(int depth, int x, int y) {
        for (int i = x; i >= 0; i--) {
            if (arr[depth][i][y] == 6) break;
            arr[depth][i][y] = -1;
        }
    }

    public static void downCheck(int depth, int x, int y) {
        for (int i = x; i < N; i++) {
            if (arr[depth][i][y] == 6) break;
            arr[depth][i][y] = -1;
        }
    }
}

class Point1 {
    int x, y, z;

    public Point1(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
