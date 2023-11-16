package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역{
	static int n;
	static int[][] map;
	static boolean[][] checked;
	//				  오  아래  왼  위
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0,- 1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];		
		int maxHeight=0; // 영역의 최대 높이
		
		// 지도 초기화 & 영역 최대 높이 계산
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) 
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > maxHeight) 
				{
					maxHeight = map[i][j];
				}
			}
		}
		
		int max =0; // 안전 영역의 수 중 최대값
		
		// 비의 높이 별로 반복
		for(int height = 0; height < maxHeight + 1; height++) 
		{
			checked = new boolean[n][n];
			int cnt=0;
			for(int i = 0; i < n; i++) 
			{
				for(int j = 0; j < n; j++) 
				{
					// 안전 영역이면
					if(!checked[i][j] && map[i][j] > height)
					{	// 해당 안전영역 탐색 시작
						cnt += dfs(i,j,height); 
					}
					
				}
			}
			if (max < cnt) max = cnt;
		}
		
		System.out.println(max);
	}
	
	// 안전 영역 DFS탐색
	static int dfs(int x, int y, int height) 
	{
		checked[x][y] = true;
		for(int i = 0; i < 4; i++) 
		{
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX > n-1 || nextY > n-1) continue;
			if(checked[nextX][nextY]) continue;
			if(map[nextX][nextY] > height) 
			{
				dfs(nextX,nextY, height);
			}
		}
		// 하나의 안전영역 탐색이 끝나면 1을 리턴
		return 1;
	}
}
