package week10;

import java.io.*;
import java.util.*;
public class 상범빌딩 {
	static int L; // 상범 빌딩의 층 수
	static int R; // 한 층의 행 수
	static int C; // 한 층의 열 수
	static char[][][] building;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true)
		{
			st = new StringTokenizer(br.readLine());
			if (!st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0) 
				break;
			
			building = new char[L][R][C];
			visited = new boolean[L][R][C];
			int sr = 0, sc = 0, sl = 0; // 출발지점 행, 열, 층
			int er = 0, ec = 0, el = 0; // 도착지점 행, 열, 층
			
			for (int l = 0; l < L; l++) // 층별
			{
				for (int r = 0; r < R; r++) // 행별
				{	
					String floor = br.readLine();
					for (int c = 0; c < C; c++)
					{
						building[l][r][c] = floor.charAt(c);
						if(floor.charAt(c) == 'S')
						{
							sr = r;
							sc = c;
							sl = l;
						}
						else if (floor.charAt(c) == 'E')
						{
							er = r;
							ec = c;
							el = l;
						}
					}
				}
				br.readLine(); // 빈 줄 입력
			}// end for
			bfs(sl, sr, sc);
		} // end while
	}
	
	static void bfs(int sl, int sr, int sc)
	{
		// 방향 : 동서남북상하
		int[][] dir = {{0, 0, 1}, {0, 0, -1}, {0, -1, 0}, {0, 1, 0}, {1, 0, 0}, {-1, 0, 0}};
	
		Queue<int[]> que = new LinkedList<>();
		int[] first = {sl, sr, sc, 0}; // 마지막 인덱스 -> 시간
		que.add(first);
		visited[sl][sr][sc] = true;
		
		while(!que.isEmpty())
		{
			int[] cur = que.poll();
			if (building[cur[0]][cur[1]][cur[2]] == 'E')
			{
				System.out.printf("Escaped in %d minute(s).\n", cur[3]);
				return;
			}
			
			for(int i = 0; i < dir.length; i++)
			{
				int nl = cur[0] + dir[i][0]; // 층
				int nr = cur[1] + dir[i][1]; // 행
				int nc = cur[2] + dir[i][2]; // 열
				int nt = cur[3] + 1;		 // 시간
				
				if (rangeCheck(nl, nr, nc) == false)
					continue;
				if(visited[nl][nr][nc] == false && building[nl][nr][nc] != '#')
				{
					int[] next = {nl, nr, nc, nt};
					que.add(next);
					visited[nl][nr][nc] = true;
				}
			}
		}
		System.out.println("Trapped!");
	}
	
	static boolean rangeCheck(int l, int r, int c)
	{
		if (r < 0 || r >= R)
			return false;
		if (c < 0 || c >= C)
			return false;
		if (l <0 || l >= L)
			return false;
		return true;
	}
}
