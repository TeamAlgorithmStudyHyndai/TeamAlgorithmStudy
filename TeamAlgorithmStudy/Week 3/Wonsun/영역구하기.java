package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 영역구하기 {
	static int N, M; 	// N : 가로, M : 세로
	static int K;	 	// K : 직사각형의 개수
	static int count; 	// 구할 분리된 영역의 개수
	static int area;	// 한 영역의 넓이
	static int[][] paper; // 모눈종이를 표시할 배열
	static boolean[][] visited; // 방문 여부를 저장할 배열 
	static int[] dirX = {0, 0, 1, -1}; // 상(0) 하(1) 좌(2) 우(3)
	static int[] dirY = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 전역변수 초기화
		count = 0;
		paper = new int[M][N];
		visited = new boolean[M][N];
		
		/* -- 모눈종이 초기화 시작 -- */
		// 이후 K개의 줄에 직사각형의 두 꼭짓점에 좌표가 주어진다
		for(int i = 0; i < K; i ++)
		{
			st = new StringTokenizer(br.readLine());
			// 왼쪽 아래 꼭지점 X 좌표
			int leftBelowX = Integer.parseInt(st.nextToken());
			// 왼쪽 아래 꼭지점 Y 좌표
			int leftBelowY = Integer.parseInt(st.nextToken());
			// 오른쪽 위 꼭지점 X 좌표
			int rightUpperX = Integer.parseInt(st.nextToken());
			// 오른쪽 위 꼭지점 Y 좌표
			int rightUpperY = Integer.parseInt(st.nextToken());
			
			for (int y = 0; y < M; y ++)
			{
				for(int x = 0; x < N; x++)
				{
					if ((leftBelowX <= x && x < rightUpperX) &&
						(leftBelowY <= y && y < rightUpperY))
					{
						paper[y][x] = 1;
					}
				}
			}
		}
		/* -- 모눈종이 초기화 끝 -- */
		
		List<Integer> areas = new ArrayList<>(); // 각 영역의 넓이를 저장할 리스트
		
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if(paper[i][j] == 0 && visited[i][j] == false)
				{
					area = 0;
					count++;
					search(i, j);
					areas.add(area);
				}
			}
		}
		
		/* 출력 */
		System.out.println(count);
		Collections.sort(areas); // 정렬
		for(int i = 0; i < areas.size(); i++)
		{
			System.out.print(areas.get(i) + " ");
		}
		
	}
	
	// 탐색 메소드	        탐색 시작 인덱스
	static void search(int y, int x)
	{
		visited[y][x] = true; // 방문지점 체크
		area++;  // 1번 호출 -> 넓이 1 증가
		
		for(int i = 0; i < 4; i++)
		{
			int nextX = x + dirX[i];
			int nextY = y + dirY[i];
			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
			if (paper[nextY][nextX] == 0 && visited[nextY][nextX] == false)
			{
				search(nextY, nextX);
			}
		}
	}
}
