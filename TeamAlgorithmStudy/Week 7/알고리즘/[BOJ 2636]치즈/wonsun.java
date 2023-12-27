package week7;

import java.io.*;
import java.util.*;

public class 치즈 {
	static boolean[][] visited;
	static int[] 	dx = {0, 1, 0, -1};
	static int[] 	dy = {1, 0, -1, 0};
	static int[][] 	arr;
	static int 		n, m; 	// 세로, 가로
	static int 		cheese; // 남아있는 치즈의 수

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		cheese = 0;
		for (int i = 0; i < n; i++) 
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) 
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					cheese++;
			}
		}
		
		// 치즈가 모두 녹아서 없어지는데 걸리는 시간
		int time = 0;
		// 시간대별로 남아 있는 치즈 수 저장할 리스트
		List<Integer> list = new ArrayList<>();
		while (cheese > 0) 
		{
			time++;
			list.add(cheese);
			bfs();
		}
		// 치즈가 다 녹기 한 시간 전 치즈의 개수
		int answer = list.get(list.size() - 1);
		System.out.println(time);
		System.out.println(answer);
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		visited = new boolean[n][m];
		visited[0][0] = true;
		while (!q.isEmpty()) 
		{
			int[] cur = q.poll();
			// 현재 위치 기준 4방향 탐색
			for (int i = 0; i < 4; i++) 
			{
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				//                                            ↓ 이거 없어서 자꾸 안됐음
				if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx] == true)
					continue;
				if (arr[ny][nx] == 1) 
				{
					cheese--;
					arr[ny][nx] = 0;
				}
				else if (arr[ny][nx] == 0)
				{
					q.add(new int[] {nx, ny});
				}
				visited[ny][nx] = true;
			}
		}
	}
}
