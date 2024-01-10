package week9;

import java.io.*;
import java.util.*;
public class 부분합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수열 길이
		int S = Integer.parseInt(st.nextToken()); // 합 S 
		int answer = Integer.MAX_VALUE;
		
		int seq[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
		{
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum  = seq[0];
		while (start <= end && end < N)
		{
			//System.out.printf("[%d, %d] sum = %d | len : %d",start, end, sum, end - start + 1);
			// 합이 S 보다 크다면 -> start 증가
			if (sum >= S)
			{
				//System.out.println(" (O) -> - " + seq[start]);
				if(answer > (end - start + 1)) answer = end - start + 1;
				sum -= seq[start];
				start++;
			}
			else // 합이 S보다 작다면 -> end 증가
			{
				end++;
				if (end < N)
				{
					sum += seq[end];
					//System.out.println(" (X) -> + " + seq[end]);
				}
			}
		}
		//System.out.println();
		// S를 만드는 것이 불가능하다면 0을 출력
		if (answer == Integer.MAX_VALUE)
			answer = 0;
		System.out.println(answer);
	}
	

}
