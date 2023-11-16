import java.util.Scanner;
public class Main {
	static int [] dp;
	public static void main(String[] args) {
		Main ma =new Main();
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		dp = new int[num+1];
		
		ma.Deepy(num);
	}
	public void Deepy(int num) {
		if(num >=3 )
			 dp[3] = 1;
		if(num >=5) {
			dp[5] = 1;
		    for(int i=6; i<dp.length; i++) {
		       if(i % 5 == 0) {
		        	dp[i] = dp[i-5]+1;
		       }else if(i % 3 == 0) {
		        	dp[i] = dp[i-3]+1;
		       }else {
					if (dp[i - 3] != 0 && dp[i - 5] != 0) {
						dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
					}
				}
		    }
		}
		if(dp[num] == 0) {
			System.out.print(-1);
		}else {
			System.out.print(dp[num]);
		}
	}
}