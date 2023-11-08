import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] dp = new int[a + 1];

        if (a <= 4) {
        	if(a == 3) System.out.println(1);
        	else System.out.println(-1);
            return;
        }
        dp[3] = 1;
        dp[5] = 1;
        for (int i = 5; i <= a; i++) {
        	if(dp[i-5] != 0 && dp[i-3] != 0)
        		dp[i] = Math.min(dp[i - 5] + 1, dp[i - 3] + 1);
        	else if(dp[i-3] != 0) dp[i] = dp[i - 3] + 1;
        	else if(dp[i-5] != 0) dp[i] = dp[i - 5] + 1;
            
        }
        if (dp[a] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[a]);
        }
    }
}
