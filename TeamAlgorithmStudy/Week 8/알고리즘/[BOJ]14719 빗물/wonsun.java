package week8;

import java.util.*;
import java.io.*;
public class 빗물 {
	static int H;
	static int W;
	static int[][] block;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/* 입력 */
		H = Integer.parseInt(st.nextToken()); // 세로 길이
		W = Integer.parseInt(st.nextToken()); // 가로 길이
		
		/* block 초기화 */
		block = new int[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++)
		{
			initColumn(Integer.parseInt(st.nextToken()), i);
		}
		
		/* 행별로 빗물의 양 계산 */
		for (int i = 0; i < H; i++)
		{
			fillRow(i);
		}
		
		/* 결과 출력 */
		int result = count();
		System.out.println(result);
	}
	
	// block 초기화(입력)
	static void initColumn(int h, int col)
	{
		for (int i = 0; i < h; i++)
		{
			block[H - 1 - i][col] = -1;
		}
	}
	
	// 행 별로 빗물 채우기 -> 양 옆이 벽으로 막힌 부분을 채운다
	// 벽이 나오면 -> 다음 벽이 나올 때 까지 채운다
	static void fillRow(int row)
	{
		for(int i = 0; i < W; i++)
		{
			if(block[row][i] == 0 && isBlocked(row, i) == true)
				block[row][i] = 1;
		}
	}
	
	// row 행에서, col 번쨰 열이 벽으로 둘러쌓인 열인지
	static boolean isBlocked(int row, int col)
	{
		int left = col - 1;
		int right = col + 1;
		
		// 좌측 확인
		while (left >= 0 && block[row][left] != -1)
		{
			left--;
		}
		// 우측 확인
		while (right < W && block[row][right] != -1)
		{
			right++;
		}
		
		if (left >= 0 &&  right < W && 
				block[row][left] == -1 && block[row][right] == -1)
			return true;
		
		return false;
	}
	
	// block 에서 빗물이 고인 칸의 개수
	static int count()
	{
		int count = 0;
		for (int i = 0; i < H; i++)
		{
			for(int j = 0; j < W; j++)
			{
				if(block[i][j] == 1)
					count++;
			}
		}
		return count;
	}
}
