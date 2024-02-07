import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n+1];
        dp = new int[n+1];
        for(int i=1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        for(int i=1; i <= n; i++){
            solution(i);
        }
        System.out.println(dp[n]);
    }
    static void solution(int num){
        for(int i =1; i <=num; i++){
            dp[num] = Math.max(Math.max(dp[num-i]+dp[i], arr[num]), dp[num]);
        }
    }

}
