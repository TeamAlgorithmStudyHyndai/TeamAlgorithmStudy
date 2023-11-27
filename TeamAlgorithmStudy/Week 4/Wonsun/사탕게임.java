import java.io.*;
import java.util.Arrays;
public class Main {
	static int N;
	static char[][] candy;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		candy = new char[N][N];
		for (int i = 0; i < N; i++)
		{
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++)
			{
				candy[i][j] = str.charAt(j);
			}
		}
		
		int maxCandy = getMax(candy); // 교환 하기 전 최대값
		// 가능한 최대값은 N 보다 클 수 없다
		// 교환 전에 이미 N이 나오면 바로 리턴
		if (maxCandy == N) 
		{	
			System.out.println(maxCandy);
			return;
		}
        // 교환 & 탐색 시작
		for (int i = 0; i < N ; i++)
		{
			for (int j = 0; j < N; j++)
			{   //IndexOutofBounds 를 피하기 위한 케이스 분류
				if (i + 1 < N && j + 1 < N) 
				{
					// i 번 행에서 ->  j 번 열과 j + 1번 열 교환 (양옆)
					char[][] tmp = swap(i, j, i ,j + 1);
					if (getMax(tmp) > maxCandy) maxCandy = getMax(tmp);

					// j 번 열에서 -> i 번 행과 i + 1 번 행 교환 (위아래)
					char[][] tmp2 = swap(i, j, i + 1, j);
					if (getMax(tmp2) > maxCandy) maxCandy = getMax(tmp2);
				}
				else if (j + 1 >= N) // 1열과 2열 원소 비교
				{
					char[][] tmp = swap(i, N - 2, i, N - 1);
					if (getMax(tmp) > maxCandy) maxCandy = getMax(tmp);
				}
				else if (i + 1 >= N)
				{
					char[][] tmp = swap(N - 2, j, N - 1, j);
					if (getMax(tmp) > maxCandy) maxCandy = getMax(tmp);
				}
				
			}
			
		}
		System.out.println(maxCandy);
	}
	
	// 수행마다 배열이 변경되면 안되기 때문에 배열을 복사해서 사용
	// candy 배열 복사 -> 두 칸 교환 -> 리턴
	// (i1, j1) <-> (i2, j2)
	static char[][] swap(int i1, int j1, int i2, int j2)
	{
		// table 복사
		char[][] tmpTable = new char[N][N];
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				tmpTable[i][j] = candy[i][j];
			}
		}
        //교환
		char tmp = tmpTable[i1][j1];
		tmpTable[i1][j1] = tmpTable[i2][j2];
		tmpTable[i2][j2] = tmp;
		return tmpTable;
	}
	
	// 이차원 배열에서 상근이가 먹을 수 있는 사탕의 최대 개수 <- 교환 하고 호출
	static int getMax(char[][] table)
	{
		int max = 0;
		// 1. 행 검사
		for(int i = 0; i < N; i++)
		{
			if (countRow(table, i) > max) max = countRow(table, i);
		}
		// 2. 열 검사
		for (int j = 0; j < N; j++)
		{
			if (countCol(table, j) > max) max = countCol(table, j);
		}
		return max;
	}
	
	// 한 행에서 가장 긴 연속된 사탕의 개수
	static int countRow(char[][] table, int row)
	{
		int count = 1;
		int max = 1;
		for (int j = 0; j < N - 1; j++)
		{
			if(table[row][j] == table[row][j + 1])
			{
				count++;
			}
			if (table[row][j] != table[row][j + 1]) 
			{
				count = 1;
			}
			if (max < count) max = count;
		}
		return max;
	}
	// 한 열에서 가장 긴 연속된 사탕의 개수
	static int countCol(char[][] table, int col)
	{
		int count = 1;
		int max = 1;
		for (int i = 0; i < N - 1; i++)
		{
			if(table[i][col] == table[i + 1][col])
			{
				count++;
			}
			if (table[i][col] != table[i + 1][col]) 
			{
				count = 1;
			}
			if (max < count) max = count;
		}
		return max;
	}
	
	/* 디버깅용 */
	static void printTable(char[][] table)
	{
		for (int i = 0; i < table.length; i++)
		{
			for (int j = 0; j < table.length; j++)
			{
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
}
