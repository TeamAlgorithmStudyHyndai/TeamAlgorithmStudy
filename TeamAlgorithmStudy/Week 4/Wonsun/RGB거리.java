import java.io.*;
import java.util.*;
public class Main {
	static int N;	// 집의 수
	static int R = 1;
	static int G = 2;
	static int B = 3;
	static int[][] house;
	static int[][] ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		house = new int[N + 1][4];
		ans = new int[N + 1][4]; // ans[i][1~3] => i 번 집을 (1 ~ 3) 색으로 칠할 때 최소값
		/* 입력 */
		for (int i = 1; i <= N; i ++)
		{
			st = new StringTokenizer(br.readLine()); 		// i 번 집
			house[i][R] = Integer.parseInt(st.nextToken()); // 빨강 비용
			house[i][G] = Integer.parseInt(st.nextToken()); // 초록 비용
			house[i][B] = Integer.parseInt(st.nextToken());	// 파랑 비용
		}
		
		ans[1][R] = house[1][R]; // 1구역 R로 칠했을 경우의 최솟값
		ans[1][G] = house[1][G]; // 1구역 G로 칠했을 경우의 최솟값
		ans[1][B] = house[1][B]; // 1구역 B로 칠했을 경우의 최솟값
		
		// i 번 집을 R 로 칠할때의 최소값 = house[i][R] + (ans[i-1][G], ans[i-1][B] 중 최소값)
		for (int i = 2; i <= N; i++)
		{
			ans[i][R] = house[i][R] + Math.min(ans[i - 1][G], ans[i - 1][B]);
			ans[i][G] = house[i][G] + Math.min(ans[i - 1][R], ans[i - 1][B]);
			ans[i][B] = house[i][B] + Math.min(ans[i - 1][G], ans[i - 1][R]);
		}
		
		// 최소값 출력
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 3; i++)
		{
			if(min > ans[N][i]) min = ans[N][i];
		}
		System.out.println(min);
	}
	
}
