package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class 유기농배추 {
	static int N, M, K;
	static int[][] cabbage;
	static int worm;
	static boolean[][] visited;
	//			         ↓  ↑  ←   → 
	static int[] dirX = {0, 0, -1, 1};
	static int[] dirY = {-1, 1, 0, 0};
	static int	now_x;
	static int	now_y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 0 ; t < T; t++)
		{
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치의 개수
			cabbage = new int[N][M];
			visited = new boolean[N][M];
			worm = 0; // 지렁이
			
			// 배추밭 초기화
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cabbage[y][x] = 1;
			}
			
			for(int j = 0; j < N; j++)
			{
				for(int i = 0; i < M; i++)
				{
					if(cabbage[j][i] == 1 && visited[j][i] == false)
					{
						DFS(i, j);
						worm++;
					}
				}
			}
			System.out.println(worm);
		}
		
	}

	static boolean rangeCheck() {
		return (now_y < N && now_y >= 0 && now_x < M && now_x >= 0);
	}
	
	static void DFS(int x, int y) {
		visited[y][x] = true;

		for(int i=0; i<4; i++) {
			now_x = x + dirX[i];
			now_y = y + dirY[i];
			
		
			if(rangeCheck() &&visited[now_y][now_x] == false && cabbage[now_y][now_x] == 1) 
			{
				DFS(now_x, now_y);
			}

		}
		
		
	}
}
