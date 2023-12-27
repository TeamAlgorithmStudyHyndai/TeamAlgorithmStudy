package week7;

import java.io.*;
import java.util.*;
public class 나무자르기 {
	static int[] trees;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int 	N;		// 나무의 수
		int 	M;		// 가져갈 나무 길이
		int		resultHeight;		// 절단기 높이
		int 	maxHeight;	// 가장 큰 나무 높이
		
		/* 입력 */
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		maxHeight = 0;
		st = new StringTokenizer(br.readLine());
		trees = new int[N];
		for (int i = 0; i < N; i++)
		{
			trees[i] = Integer.parseInt(st.nextToken());
			if(maxHeight < trees[i]) maxHeight = trees[i];
		}
		/* 탐색 */
		resultHeight = 0;
		int max = maxHeight;	// 높이의 최대값
		int min = 0;			// 높이의 최소값
		// 가능한 높이의 최대값을 구해야 한다
		while (min <= max)
		{
			int mid = (max + min) / 2;
			System.out.printf("max : %d | min : %d | mid : %d | sum : %d\n",max, min, mid, sumLength(mid));
			if (sumLength(mid) >= M)// 나무 길이가 충분하면 -> 높이를 높인다
			{
				resultHeight = mid;
				min = mid + 1;
			}
			else // 나무 길이가 부족하면 -> 높이를 낮춘다
			{
				max = mid - 1;
			}
		}
		System.out.println(resultHeight);
	}
	
	// 절단기 높이가 h 일 때 가져가는 나무 길이의 합
	static long sumLength(int h)
	{
		long sum = 0;
		for (int i = 0; i < trees.length; i++)
		{
			int len = trees[i] - h;
			if (len > 0)
				sum += len;
		}
		return sum;
	}
	
}
