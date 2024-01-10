package week9;

import java.io.*;
import java.util.*;

public class 파이프옮기기 {
	static final int HOR = 0; // 가로
	static final int VER = 1; // 세로
	static final int DIA = 2; // 대각선
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N + 1][N + 1];
		int[][][] dp = new int[N + 1][N + 1][3];
		
		for (int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++)
			{
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 처음 파이프 상태
		dp[1][2][HOR] = 1;
		
		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= N; j++)
			{
				if (house[i][j] == 1) 
					continue;
				
				// 1. (i, j) 가로
				dp[i][j][HOR] += dp[i][j -1][HOR] + dp[i][j - 1][DIA];
				// 2. (i, j) 세로
				dp[i][j][VER] += dp[i-1][j][VER] + dp[i-1][j][DIA];
				// 3. (i, j) 대각선
				if(house[i-1][j] == 0 && house[i][j-1] == 0)
				{
					dp[i][j][DIA] += dp[i-1][j-1][HOR]; 
					dp[i][j][DIA] += dp[i-1][j-1][VER]; 
					dp[i][j][DIA] += dp[i-1][j-1][DIA]; 
				}
			}
		}
		
		int answer = 0;
		answer += dp[N][N][HOR];
		answer += dp[N][N][VER];
		answer += dp[N][N][DIA];
		System.out.println(answer);
	}

}
