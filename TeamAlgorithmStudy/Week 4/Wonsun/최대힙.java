package week5;

import java.io.*;
import java.util.*;
public class 최대힙 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 연산의 개수
		
		//													내림차순 정렬
		PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());

		// N개의 줄에 정수 x 가 주어진다
		// x 가 자연수 -> 배열에 x 값 추가
		// x 가 0 -> 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거
		// 배열이 비어있는 경우 출력해야한다면 -> 0 출력
		for (int i = 0; i < N; i++)
		{
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0)
			{
				if(pQue.isEmpty())
					System.out.println(0);
				else
					System.out.println(pQue.poll());
			}
			else
			{
				pQue.add(num);
			}
			
		}
	}

}
