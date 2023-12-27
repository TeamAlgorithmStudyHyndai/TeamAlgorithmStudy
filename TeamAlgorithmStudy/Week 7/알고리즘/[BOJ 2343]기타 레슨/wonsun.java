package week7;

import java.io.*;
import java.util.*;
public class 기타레슨 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/* 입력 */
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long sum = 0;	// 모든 강의 길이의 합
		long min = 0;
		long max = 0;
		int[] lessons = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
		{
			lessons[i] = Integer.parseInt(st.nextToken());
			sum += lessons[i];
			if (min < lessons[i])
				min = lessons[i];
		}

		/* 이분 탐색 */
		max = sum;
		while (min <= max)
		{
			long mid = (min + max) / 2;
			long sumLength = 0;	 // 한 블루레이에 들어간 강의 길이 합
			long count = 0; 	// 블루레이 개수
			
			// 0번 강의부터 ... (N - 1) 번 강의까지 순서대로 블루레이에 담는다
			for(int i = 0; i < N; i++)
			{
				// 블루레이에 강의 더 못들어가면(용량 초과)
				if(sumLength + lessons[i] > mid) 
				{ 
					count++; // 다음 블루레이로
					sumLength = 0; // 강의 길이 합 초기화
				}
				// 강의 더 들어갈 수 있다면
				sumLength += lessons[i];
			}
			
			// sumLength 가 0이 아니다 -> 블루레이에 넣다가 (모든 강의를 다 넣어서) 반복문이 끝났다
			if(sumLength != 0)
				count++;
			// count 가 M 보다 작다면 -> 사이즈를 줄인다
			if (count <= M)
				max = mid - 1;
			else // count 가 M 보다 크다면 -> 사이즈를 키운다
				min = mid + 1;
		}
		
		System.out.println(min);
	}
	
}
