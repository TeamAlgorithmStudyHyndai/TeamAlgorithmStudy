import java.util.Scanner;

public class Main {
		static long[] dp ;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int num = sc.nextInt();
			dp = new long[num+4];
			
			dp[1] = 1;
			dp[2] =1;
			for(int i = 3 ; i < num+1 ; i ++) {
				dp[i]= dp[i-2]+dp[i-1];
			}
			
			System.out.println(dp[num]);
		}
}
