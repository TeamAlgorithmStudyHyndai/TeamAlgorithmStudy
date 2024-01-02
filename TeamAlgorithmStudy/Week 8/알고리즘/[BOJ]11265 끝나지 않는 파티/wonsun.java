package week8;

import java.io.*;
import java.util.*;
public class 끝나지않는파티 {
	static int N; // 파티장의 크기
	static int M; // 서비스를 요청한 손님의 수
	static int[][] map; // 처음에 입력받는 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		
		/* map 배열 입력 */
		for (int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		floyd();
		
		/* 손님 별로 결과 출력 */
		for (int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 손님이 위치한 파티장의 번호
			int B = Integer.parseInt(st.nextToken()); // 다음 파티가 열리는 파티장의 번호
			int C = Integer.parseInt(st.nextToken()); // 주어진 시간
			
			if (map[A][B] <= C)
				System.out.println("Enjoy other party");
			else
				System.out.println("Stay here");
		}
	}
	
	// map 배열에 플로이드 워셜 적용
	static void floyd()
	{
		// 플로이드 워셜 
		for (int k = 1; k <= N; k++)
		{
			for (int i = 1; i <= N; i++)
			{
				for (int j = 1; j <= N; j++)
				{
					if (map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
	}
}
