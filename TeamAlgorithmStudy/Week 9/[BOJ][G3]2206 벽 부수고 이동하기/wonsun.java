package week9;

import java.io.*;
import java.util.*;
public class 벽부수고이동하기 {
	static int N;
	static int M;
	static int[][] map;
	static class Node{
		int y;
		int x;
		int distance;
		boolean broke; // 벽을 부순 횟수
		
		public Node(int y, int x, int dis, boolean bc) {
			this.y = y;
			this.x = x;
			this.distance = dis;
			this.broke = bc;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++)
		{
			String str = br.readLine();
			for (int j = 0; j < M; j++)
			{
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int result = bfs();
		System.out.println(result);
	}
	
	static int bfs()
	{
		int[] yDir = {1, -1, 0, 0};
		int[] xDir = {0, 0, 1, -1};
		// visited[][][0] -> 벽을 안부수고 이동한 경우
		// visited[][][1] -> 벽을 부수고 이동한 경우
		boolean[][][] visited = new boolean[N][M][2];
		
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0, 0, 1, false));
		visited[0][0][0] = true;
		while (!que.isEmpty())
		{
			Node cur = que.poll();
			if(cur.y == N -1 && cur.x == M - 1)
				return cur.distance;
			for (int i = 0; i < 4; i++)
			{
				int ny = cur.y + yDir[i];
				int nx = cur.x + xDir[i];
				// 인덱스 조건 체크
				if (ny < 0 || nx < 0 || ny >= N || nx >= M) 
					continue;
				// 벽 & 벽을 부순적 있으면 패스
				if (map[ny][nx] == 1 && cur.broke == true)
					continue;
				// 벽을 만났지만 아직 벽을 부순적 없는 경우 -> 벽을 부수고 이동
				if (map[ny][nx] == 1 && cur.broke == false && visited[ny][nx][1] == false)
				{
					visited[ny][nx][1] = true;
					que.add(new Node(ny, nx, cur.distance + 1, true));
				}
				// 그냥 이동 (벽이 아닌 경우)
				else if (map[ny][nx] == 0)
				{
					// 벽을 부순적 없는 경우
					if(cur.broke == false && visited[ny][nx][0] == false) 
					{
						visited[ny][nx][0] = true;
						que.add(new Node(ny, nx, cur.distance + 1, cur.broke));
					}
					// 벽을 부순적 있는 경우
					else if (cur.broke == true && visited[ny][nx][1] == false)
					{
						visited[ny][nx][1] = true;
						que.add(new Node(ny, nx, cur.distance + 1, cur.broke));
					}
				}
			} // end for
		} // end while
		
		return -1;
	}
	
}
