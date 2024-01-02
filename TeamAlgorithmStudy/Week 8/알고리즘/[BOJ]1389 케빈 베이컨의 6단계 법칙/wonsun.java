package week8;

import java.io.*;
import java.util.*;

public class 케빈케이컨 {
	static int n; // 유저 수
	static int m; // 친구 관계 수
	static int[][] relation; // 친구 관계 
	static final int INF = 5001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		relation = new int[n + 1][n + 1];
		init(relation);
		
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int user1 = Integer.parseInt(st.nextToken());
			int user2 = Integer.parseInt(st.nextToken());
			relation[user1][user2] = relation[user2][user1] = 1;
		}
		
		// 유저끼리의 최단 경로 저장된 배열
		relation = floyd(relation);
		int min = INF;
		int result = 0;
		for (int i = 1; i <= n; i++)
		{
			int sum = 0;
			
			for (int j = 1; j <= n; j++)
			{
				sum += relation[i][j];
			}
			if(sum < min)
			{
				min = sum;
				result = i;
			}
		}
		System.out.println(result);
	}
	
	
	static int[][] floyd(int[][] graph)
	{
		// 플로이드 워셜
		// 각 정점을 거쳐가면서 최단 경로 갱신
		for(int k = 1; k <= n; k++)
		{
			for(int i = 1; i <= n; i++)
			{
				for(int j = 1; j <= n; j++)
				{
					// i -> j 와 i -> k -> j 비교
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		return graph;
	}
	
	// 2차원 배열 INF 로 초기화
	static void init(int[][] graph)
	{
		int len = graph.length;
		
		for (int i = 0; i < len; i++)
		{
			for(int j = 0; j < len; j++)
			{
				graph[i][j] = INF;
				if (i == j) graph[i][j] = 0;
			}
		}
	}
}
	
