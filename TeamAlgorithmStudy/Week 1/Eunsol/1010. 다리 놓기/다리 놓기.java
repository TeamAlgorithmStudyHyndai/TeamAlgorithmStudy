import java.util.Scanner;

public class Main {
	static int [][] dp= new int[30][30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Main ma = new Main();
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(ma.deepy(M,N));
		}
	}
	public int deepy(int n, int m) {
		
		//기존에 값이 있는 경우에는 그대로 return
		if(dp[n][m] >0)
			return dp[n][m];
		
		//nCn의 경우거나 nC1의 경우 1의 값을 넣어 return
		if(n == m || m==0)
			return dp[n][m] = 1;
		
		//nCm = c-1 C m-1 + n-1Cm
		return dp[n][m]=deepy(n-1,m-1)+deepy(n-1,m);
 	}
}
