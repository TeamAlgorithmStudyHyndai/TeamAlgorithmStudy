import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] home;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        home = new int[N][N];
        dp = new int[N][N][3]; // 0 가로, 1 세로, 2 대각선
        for (int i = 0; i <N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1][0] = 1; // 머리 부분이 0,1
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if(j-1 >=0 && home[i][j] == 0){
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                }
                if(i-1 >= 0 && home[i][j] ==0){
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                }
                if(i-1>=0 && j-1 >=0 &&home[i][j] == 0 && home[i-1][j] == 0 &&home[i][j-1] == 0){
                    dp[i][j][2] = dp[i-1][j-1][2] + dp[i-1][j-1][1] +dp[i-1][j-1][0];
                }
            }
        }
        int ans = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        System.out.println(ans);
    }
}
