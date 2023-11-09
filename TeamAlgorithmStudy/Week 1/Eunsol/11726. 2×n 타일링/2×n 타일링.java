
import java.util.Scanner;

public class Main {
	static int []dp ;
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		Main ma = new Main();
		
		int num = sc.nextInt();
		ma.Tiling(num);
	}
	public void Tiling(int num) {
		dp = new int[num +1];
		
		dp[1]=1;
		if(num >= 2 ) {
			dp[2]= 2;
		}
		for(int i = 3; i < num+1;i++) {
			dp[i] =(dp[i-2]+dp[i-1]) % 10007;
		}
		
		System.out.println(dp[num]);
	}

}
