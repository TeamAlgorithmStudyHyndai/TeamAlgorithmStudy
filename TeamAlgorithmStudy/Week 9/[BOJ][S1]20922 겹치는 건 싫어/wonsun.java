package week9;

import java.io.*;
import java.util.*;
public class 겹치는건싫어 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] seq = new int[N];
		int[] count = new int[100001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N;i++) seq[i] = Integer.parseInt(st.nextToken());

		int start = 0;
		int end = 0;
		int answer = 0;
		while (end < N)
		{
			// K번 겹치는 수가 나올 때까지 end 이동
			while(end < N && count[seq[end]] < K)
			{
				count[seq[end]]++;
				end++;
			}
			answer = Math.max(answer, end - start);
			// start 이동
			count[seq[start]]--;
			start++;
		}
		
		System.out.println(answer);
	}

}
