import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   
        int[][] rgb = new int[n][3]; 
        int[][] dp = new int[n][3];
        for(int i =0; i<n; i++) {
        	String[] s = br.readLine().split(" ");
        	rgb[i][0] = Integer.parseInt(s[0]);
        	rgb[i][1] = Integer.parseInt(s[1]);
        	rgb[i][2] = Integer.parseInt(s[2]);
        }
        for(int i =0; i<3; i++) 
        	dp[0][i] = rgb[0][i];
        
        for(int i = 1; i< n; i++) {
        	dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + rgb[i][2];
        }
        int res = Integer.MAX_VALUE;
        for(int i =0; i<3; i++) 
        	res = Math.min(res, dp[n-1][i]);
        System.out.println(res);
        
    }
}
