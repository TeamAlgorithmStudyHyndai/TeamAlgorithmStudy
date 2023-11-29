import java.util.Scanner;

public class Main {

    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main ma = new Main();
        int N = sc.nextInt();
        int K = sc.nextInt();
        dp = new int[N + 1][K + 1];
        
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            int W = sc.nextInt(); // 물건의 무게 W
            int V = sc.nextInt(); // 물건의 가치 V

            arr[i][0] = W;
            arr[i][1] = V;
        }

        ma.DP(N, K);
    }

    public void DP(int N, int K) {
  
    	for (int i = 1; i <= N; i++) {
    	    int weight = arr[i - 1][0];
    	    int value = arr[i - 1][1];

    	    //최대 K만큼의 무게범위까지만 측정
    	    for (int w = 1; w <= K; w++) {
    	    	if (weight <= w) {
    	    		//i번째 까지의 배낭의 최대 가치
    	    	    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight] + value);
    	    	} else {
    	    	    dp[i][w] = dp[i - 1][w];
    	    	}
    	    }
    	}


        System.out.println(dp[N][K]);
    }
}
