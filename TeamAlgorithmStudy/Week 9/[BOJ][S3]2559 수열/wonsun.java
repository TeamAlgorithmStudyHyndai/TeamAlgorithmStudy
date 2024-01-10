package week9;

import java.io.*;
import java.util.*;
public class 수열 {
	static int N;
	static int K;
	static int[] temps;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 전체 날짜의 수 (2 ~ 100,000)
		K = Integer.parseInt(st.nextToken()); // 합을 구하기 위한 연속적인 날짜의 수 (1 ~ N)
		temps = new int[N];
		
		int maxSum = 0; // 온도의 합의 최대값
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) temps[i] = Integer.parseInt(st.nextToken()); 
		
		int sum = 0;
		for (int i = 0; i < K; i++) sum += temps[i]; // sum 초기화 (처음 날짜부터 K일 동안의 합)
		maxSum = sum;
		
		for (int i = K; i < N; i++)
		{
			sum += temps[i];
			sum -= temps[i - K];
			
			if (maxSum < sum) maxSum = sum;
		}
		
		System.out.println(maxSum);
	}
	
	
}
