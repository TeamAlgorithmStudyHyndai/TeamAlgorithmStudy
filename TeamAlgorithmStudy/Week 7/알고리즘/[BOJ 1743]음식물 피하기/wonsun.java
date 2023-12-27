package week7;

import java.util.*;
import java.io.*;

public class 음식물피하기 {
	static int N; // 통로 세로 길이
	static int M; // 통로 가로 길이
	static int K; // 음식물 쓰레기 개수
	static int size; // 음식물 쓰레기 사이즈
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int [N + 2][M + 2];
		visited = new boolean[N + 2][M + 2];		
		for (int i = 0 ; i < K; i++)
		{
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r][c] = 1;
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++)
		{
			for(int j = 1; j <=M ; j++)
			{
				if(arr[i][j] == 1 && visited[i][j] == false)
				{
					size = 0;
					dfs(i, j);
				}
				if (max < size) max = size;
			}
		}
		System.out.println(max);
	}
	
	static void dfs(int r, int c)
	{
		visited[r][c] = true;
		size++;
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for (int i = 0; i < 4; i++)
		{
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			if (arr[nextR][nextC] == 1 && visited[nextR][nextC] == false)
			{
				dfs(nextR, nextC);
			}
		}
	}
}
