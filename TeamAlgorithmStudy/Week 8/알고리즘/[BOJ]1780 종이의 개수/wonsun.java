package week8;

import java.io.*;
import java.util.*;
public class 종이의개수 {
	static int N;
	static int[] result; // 결과(-1, 0, 1 로 채워진 종이의 개수)
	static int[][] paper;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		result = new int[3];
		
		/* 초기 종이 입력 */
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
			{
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 분할 정복 메소드 실행 */
		divideRecursion(paper);
		
		/* 결과 출력 */
		for(int i : result)
		{
			System.out.println(i);
		}
	}

	// 길이가 N = 3^k -> 길이 n = 3 ^(k - 2) 인 종이 9개로 분할 
	static void divideRecursion(int[][] arr)
	{
		int len = arr.length;
		int newLen = len / 3;
		
		// 모두 같은 색으로 구성거나 길이가 1인 경우 -> 탈출
		if(checkWhole(arr) == true)
		{
			if (arr[0][0] == -1)
				result[0]++;
			else if (arr[0][0] == 0)
				result[1]++;
			else if (arr[0][0] == 1)
				result[2]++;
			return;
		}
		
		// 그렇지 않다면 -> 2차원 배열 9개로 나눈다
		List<int[][]> list = new ArrayList<>();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				int[][] newPaper = dividePaper(arr, i * newLen, j * newLen, newLen);
				list.add(newPaper);
			}
		}
		
		// 나눠진 9개의 종이에 대해 다시 검사
		for (int[][] newPaper : list)
		{
			divideRecursion(newPaper);
		}
		
	}
	
	// 종이가 모두 같은 수로 되어 있는지 체크하는 메소드
	static boolean checkWhole(int[][] arr)
	{
		int len = arr.length;
		int init = arr[0][0]; // 배열의 첫 원소
		
		if (len == 1)
			return true;
		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				if(init != arr[i][j])
					return false;
			}
		}
		
		return true;
	}
	
	// 배열의 일부 추출 (m x m)                  시작 행   시작 열     길이
	static int[][] dividePaper(int[][] arr, int r, int c, int len)
	{
		int[][] newPaper = new int[len][len];
		
		for (int i = 0; i < len; i++)
		{
			for (int j = 0; j < len; j++)
			{
				newPaper[i][j] = arr[r + i][c + j];
			}
		}
		return newPaper;
	}
}
