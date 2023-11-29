import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n,res;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i =0; i< n; i++) {
        	String[] s = br.readLine().split(" ");
        	for(int j =0; j< s.length; j++) {
        		arr[i][j] = Integer.parseInt(s[j]);
        	}
        }
        
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for(int i = 1; i<n;i++) {
        	for(int j = 0; j<n; j++) {
        		if(j == 0) dp[i][j] = dp[i-1][0] + arr[i][0];
        		else if(j == i) dp[i][j] = dp[i-1][i-1] + arr[i][j];
        		else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
        	}
        }
        res = -1;
        for(int i = 0; i<n;i++) {
        	res = Math.max(res, dp[n-1][i]);
        }
        System.out.println(res);
    }
}
