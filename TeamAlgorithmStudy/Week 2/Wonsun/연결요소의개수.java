package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 문제 */
// 방향 없는 그래프가 주어졌을 때, 
// 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
public class 연결요소의개수 {
	static boolean[] marked; // 정점 방문 여부
	static int[][] graph;  // 그래프
	static int 	N; 		// 정점의 개수
	static int 	M; 		// 간선의 개수
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int	links = 0;; // 연결 요소의 개수
		/* 입력 */
		// 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
		// (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
		// 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v)
		// 같은 간선은 한 번만 주어진다.
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][N + 1];
		marked = new boolean [N + 1];
		for (int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = 1;
		}
		
		/* 출력 */
		// 첫째 줄에 연결 요소의 개수를 출력한다.
		for(int i = 1; i <= N; i++)
		{
			if(marked[i] == false)
			{
				findLinks(i);
				links++;
			}
		}
		System.out.println(links);
		
	}
	
	// DFS
	static void findLinks(int u) {
		// 재귀 탈출은 언제?
		// -> 더 탐색할 노드가 없을 때
		if(marked[u] == true)
			return;
		marked[u] = true;
		for (int j = 1; j <= N; j++) {
			// u 와 i 가 연결되어 있고 && i를 방문하지 않은 상태라면
			if (graph[u][j] == 1 && marked[j] == false) {
				findLinks(j);
			}
		}

	}
}
