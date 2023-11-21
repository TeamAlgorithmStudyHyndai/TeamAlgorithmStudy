package week3;

import java.io.*;
import java.util.*;
public class N과M12 {
	static int N;
	static int M;
	static int[] nums;	 // 주어진 N개의 수를 저장할 배열
	static int[] result; // 길이가 M 인 수열
	static Set<String> resultSet = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/* 입력 */
		N = Integer.parseInt(st.nextToken()); // N 개의 자연수가 주어진다
		M = Integer.parseInt(st.nextToken()); // 수열의 길이
		nums = new int[N];	 
		result = new int[M]; 		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
		{
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums); // 정렬
		combination(0, 0); // 재귀 호출

		/* 출력 */
	    for (String sequence : resultSet)
	    {
	         System.out.println(sequence);
	    }
		
	}

	// 주어진 자연수들로 길이가 M인 수열을 생성하는 메소드
	static void combination(int length, int start) {
		/* recursion break point */
		// 길이가 M이 되었으면 resultSet에 추가하고 리턴
        if (length == M) 
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) 
            {
                sb.append(result[i]).append(" ");
            }
            resultSet.add(sb.toString().trim());
            return;
        }
        
        /* recursion */
        for (int i = start; i < N; i++) 
        {
            result[length] = nums[i];
            combination(length + 1, i);
        }
    }

}
