package week3;

import java.io.*;
import java.util.*;
public class 빙고 {
	static int[][] bingo;
	static int count; 
	static int bingoCount;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		bingo = new int[5][5];	// 빙고판
		count = 0; 				// 몇 번 만에 빙고를 외치게 되는지
		bingoCount = 0;			// 빙고 수
		/* 빙고판 초기화(5줄) */
		for(int i = 0; i < 5; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++)
			{
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 사회자가 숫자를 부른다(5줄) */
		// 사회자가 숫자를 하나 부를 때 마다 빙고가 몇 개 인지 체크 -> 3빙고 이상이면 종료
		for (int i = 0; i < 5; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)
			{	
				count++;
				int num = Integer.parseInt(st.nextToken()); 	// 사회자가 부른 숫자
				changeBlock(num);	// 사회자가 부른 숫자에 표시
				checkHorizontal();	// 가로 빙고 체크
				checkVertical();	// 세로 빙고 체크
				checkDiagonal();	// 대각선 빙고 체크
				if (bingoCount >= 3) 
				{
					System.out.println(count);
					return;
				}
				bingoCount = 0;	// 빙고 수 초기화
			}
		}
	}
	
	// 사회자가 숫자(num)을 부르면, 해당 칸을 표시(0으로 바꿈)
	static void changeBlock(int num)
	{
		for (int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(bingo[i][j] == num)
				{
					bingo[i][j] = 0;
					return;
				}
			}
		}
	}
	
	// 1.가로 빙고 체크
	static void checkHorizontal()
	{
		for(int i = 0; i < 5; i++)
		{
			int countZero = 0;
			for(int j = 0; j < 5; j ++)
			{
				if(bingo[i][j] == 0) 
				{
					countZero++;
				}
			}
			if(countZero == 5) {
				bingoCount++;
			}
		}
	}
	
	static void checkVertical()
	{
		for(int i = 0; i < 5; i++)
		{
			int countZero = 0;
			for(int j = 0; j < 5; j ++)
			{
				if(bingo[j][i] == 0) 
				{	
					countZero++;
				}
			}
			if(countZero == 5) 
			{ 
				bingoCount++;
			}
		}
	}
	
	// 3. 대각선
	static void checkDiagonal()
	{
		int countDiagonal1 = 0; 
		int countDiagonal2 = 0;
		for (int i = 0; i < 5; i++)
		{
			if (bingo[i][i] ==0) // 대각선(/) 
				countDiagonal1++;
			if (bingo[i][4 - i] == 0) // 대각선(\)
				countDiagonal2++;
		}		
		if (countDiagonal1 == 5) 
			bingoCount++;
		if (countDiagonal2 == 5) 
			bingoCount++;
	}
}
