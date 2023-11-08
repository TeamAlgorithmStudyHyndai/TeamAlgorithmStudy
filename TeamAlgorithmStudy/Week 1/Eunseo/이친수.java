import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        long[] dp = new long[100];
// n+1로 두면 1일때 dp[2]를 넣을 수 없어서 그냥 최대값으로 배열 생성
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++) 
        	dp[i] = dp[i-1] + dp[i-2];
        System.out.println(dp[n]);
    }
}
