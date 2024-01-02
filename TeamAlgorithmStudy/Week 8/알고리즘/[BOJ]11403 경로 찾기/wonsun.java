package week8;

import java.io.*;
import java.util.*;
public class 경로찾기 {
	static int N; // 정점의 개수
	static int[][] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/* 입력 */
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
			{
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 탐색(플로이드-워셜) */
		for (int k = 0; k < N; k++) // k : 경유
		{
			for (int i = 0; i < N; i++) // i : 출발
			{
				for (int j = 0; j < N; j++) // j: 도착
				{
					// i -> k -> j 로 갈 수 있으면 graph[i][j] = 1
					if(graph[i][k] == 1 && graph[k][j] == 1)
						graph[i][j] = 1;
				}
			}
		}
		
		/* 출력 */
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		

	}
	
	
}
