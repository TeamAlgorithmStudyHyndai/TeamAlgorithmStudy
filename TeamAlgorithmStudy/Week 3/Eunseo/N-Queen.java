
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] queen;
    static int N, res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        res = 0;
        queen = new int[N][N]; // queen 배열 한 번만 초기화

        for (int i = 0; i < N; i++) {
            queen[0][i] = 1; // 퀸을 첫 번째 행에 놓음
            dfs(1);
            queen[0][i] = 0; // 퀸 위치 초기화
        }

        System.out.println(res);
    }
    public static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static boolean checkOtherQueen(int x, int y) {
        // 이전 행에 놓인 퀸들을 확인
        for (int i = 0; i < x; i++) {
            if (queen[i][y] == 1) return false; // 같은 열에 있는지 확인
            if (isIn(i, y - (x - i)) && queen[i][y - (x - i)] == 1) return false; // 대각선 확인
            if (isIn(i, y + (x - i)) && queen[i][y + (x - i)] == 1) return false; // 대각선 확인
        }
        return true;
    }

    public static void dfs(int x) {
        if (x == N) {
            res++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (queen[x][i] == 0 && checkOtherQueen(x, i)) {
                queen[x][i] = 1;
                dfs(x + 1);
                queen[x][i] = 0; // 되돌리기
            }
        }
    }
}
