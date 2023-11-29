

import java.util.Scanner;

public class Main {

    static int[][] arr;
    static int[][] dp;
    static int minValue = 0;
    static int prevIndex;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main ma = new Main();
        int num = sc.nextInt();
        arr = new int[num][3];  
        dp = new int[num][3];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {  
                arr[i][j] = sc.nextInt();
            }
        }
        int minSum = 0;
        
        //첫번째 값 - color과 색에 따른 비용 설정
        for (int j = 0; j < 3; j++) { 
        	dp[0][j] = arr[0][j];
        }
        
        int data = ma.DP(num);
        System.out.println(data);
        
    }

    public int DP(int N) {
      
        for (int i = 1; i < arr.length; i++) {
           dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
           dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
           dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
    }
}
