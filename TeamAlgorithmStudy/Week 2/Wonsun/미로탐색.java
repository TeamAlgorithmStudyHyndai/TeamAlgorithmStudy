package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 
// 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성
public class 미로탐색 {
	static int[][] maze;
	static boolean[][] visited;
	static int count;
	static int N, M;
	//                  위  오  아래  왼
	static int[] dirX = {0, 1, 0, -1};
	static int[] dirY = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		// 미로 생성 & 초기화
		maze = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i ++)
		{
			String str = br.readLine();
			for(int j = 0; j < M; j++)
			{
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		/* Test */
		System.out.println("****** maze ******");
		for(int i = 0; i < N; i ++)
		{
			System.out.println(Arrays.toString(maze[i]));
		}
		System.out.println("*******************");
		/* end Test*/
		
		dfs(0, 0);
		System.out.println(count);
	}
	
	static void dfs(int y, int x)
	{
		visited[y][x] = true;
		System.out.printf("=== visit (%d, %d) ===\n", y, x);
		if(y == N -1 && x == M - 1) 
		{	
			System.out.println("///////////////");
			return;
		}
		for(int i = 0; i < 4; i ++)
		{
			int nextY = y + dirY[i];
			int nextX = x + dirX[i];
			System.out.printf("-- (nextY , nextX) = (%d, %d)\n", nextY, nextX);
			if(nextX < 0 || nextY < 0 || nextX > M - 1 || nextY > N - 1) continue;
			if(visited[nextY][nextX] == false && maze[nextY][nextX] == 1)
			{
				count++;
				dfs(nextY, nextX);
				
			}
		}
	}
}
