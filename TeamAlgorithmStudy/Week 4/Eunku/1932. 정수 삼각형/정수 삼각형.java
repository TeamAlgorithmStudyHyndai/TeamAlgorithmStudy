import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans[0][0]= arr[0][0];
        System.out.println(sol(n,1, arr, ans));
    }
    public static int sol(int n, int depth, int[][] arr, int[][] ans){
        if(depth == n){
            int max = 0;
            for (int temp:
                 ans[n-1]) {
                max = Math.max(temp, max);
            }
         return max;
        }
        for (int i = 0; i <= depth; i++) {
            ans[depth][i] = Math.max(ans[depth-1][i] + arr[depth][i], ans[depth][i]);
            if(i +1 <= depth){
                ans[depth][i+1] = Math.max(ans[depth-1][i] + arr[depth][i+1], ans[depth][i+1]);
            }
        }
        return sol(n, depth+1, arr, ans);
    }
}
