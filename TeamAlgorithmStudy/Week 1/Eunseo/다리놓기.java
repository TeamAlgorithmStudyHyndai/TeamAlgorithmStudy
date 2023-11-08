import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int t = Integer.parseInt(s);
        for(int i =0; i<t; i++) {
        	String[] str = br.readLine().split(" ");
        	int n = Integer.parseInt(str[0]);
        	int m = Integer.parseInt(str[1]);

        	int[] dp = new int[m + 1];
        	dp[n] = 1;
        	for(int j = n + 1; j <=m ;j++) {
        		dp[j] = dp[j - 1] * j / (j - n); //조합 공식
        	}
        	System.out.println(dp[m]);
        }
    }
}
