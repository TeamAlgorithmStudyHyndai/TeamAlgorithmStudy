import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int t = Integer.parseInt(s);
        for(int test =0; test<t; test++) {
        	String str = br.readLine();
        	int n = Integer.parseInt(str);
        	int[] dp = new int[12];
        	dp[1] = 1;
        	dp[2] = 2;
        	dp[3] = 4;
        	for(int i =4; i <= n; i++) 
        		dp[i] = dp[i -1] + dp[i -2] + dp[i -3];
        	System.out.println(dp[n]);
        }
    }
}
