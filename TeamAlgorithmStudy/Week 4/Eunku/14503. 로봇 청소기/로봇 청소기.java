import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    static int r, c, d;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; //북 동 남 서

    static Robot ro;

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        ro = new Robot(r, c, d);
        map = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 1;

        solution();
        System.out.println(cnt);
    }

    public static void solution() {
        check[ro.x][ro.y]=true;

        boolean[] dirty = new boolean[5];  //북 동 남 서 있는지 여부

        for (int i = 0; i < 4; i++) {
            int x = ro.x + dx[i];
            int y = ro.y + dy[i];
            if (x < 0 || y < 0 || x >= n || y >= m) continue;
            if (map[x][y] == 0 && !check[x][y]) {
                dirty[i] = true;
                dirty[4] = true;
            }
        }

        if(dirty[4]) {
            for (int j = 0; j < 4; j++) {
                ro.rotate();
                for (int i = 0; i < 4; i++) {
                if (dirty[i] && ro.z ==i) {
                    ro.x += dx[i];
                    ro.y += dy[i];
                    cnt++;
                    solution();
                    return;
                }
                }
            }
        }
        int back = (ro.z + 2) % 4;
        if (map[ro.x + dx[back]][ro.y + dy[back]] == 0) {
            ro.x += dx[back];
            ro.y += dy[back];
            solution();
        }

    }

    public static class Robot {
        public int x, y, z;

        public Robot(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public void rotate() {
            if (this.z == 0) {
                this.z = 3;
            } else this.z--;
        }
    }
}
