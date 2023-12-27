package week7;

import java.io.*;
import java.util.*;

public class 랜선자르기 {
	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken()); // 오영식이 이미 가지고 있는 랜선의 개수
		N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		
		long[] 	lans = new long[K]; // 이미 가지고 있는 각 랜선의 길이
		long	max = 0;			// 그 랜선들 중 가장 긴 길이
		for(int i = 0; i < K; i ++)
		{
			lans[i] = Long.parseLong(br.readLine());
			if(lans[i] > max) max = lans[i];
		}
		
		long min = 0;
		long mid = 0;
		max++;
		// 이분탐색
		while (min < max)
		{
			long count = 0;
			mid = (min + max) / 2;
			
			// mid 길이로 잘랐을 때 얻을 수 있는 랜선의 개수(count)를 구한다
			for (int i = 0; i < lans.length; i++)
			{
				count += lans[i] / mid;
			}
			
			// 만약 N 개보다 적으면 -> 더 작은 길이로 나눠본다
			if (count < N)
				max = mid;
			// N 개 보다 많으면 -> 더 큰 길이로 나눠본다
			else
				min = mid + 1;
		}
		System.out.println(min - 1);
	}
}
