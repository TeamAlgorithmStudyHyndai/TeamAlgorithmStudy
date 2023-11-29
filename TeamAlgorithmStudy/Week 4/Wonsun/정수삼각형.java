package week5;

import java.io.*;
import java.util.*;

public class 정수삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int triangle[][] = new int[n][n];
        int dp[][]=new int[n][n];
		int max = 0;
		// 삼각형 초기화
		for(int i = 0; i < n; i++) 
		{
			st = new StringTokenizer(br.readLine());
	       	for(int j =0; j <= i; j++) 
	       	{
	       		triangle[i][j] = Integer.parseInt(st.nextToken());
	       	}
        }

		dp[0][0] = triangle[0][0];
		for (int i = 1; i < n; i++) 
		{
			for (int j = 0; j <= i; j++) 
			{
				if (j == 0) // 가장 왼쪽
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				else if (j == j + i) // 가장 오른쪽
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				else // 그 외
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
			}
		}
		
		// dp 배열에서 최대값 구하기
		for (int i = 0; i < n; i++) 
		{
			if (max < dp[n - 1][i])	max = dp[n - 1][i];
		}
		System.out.println(max);
	}
}

