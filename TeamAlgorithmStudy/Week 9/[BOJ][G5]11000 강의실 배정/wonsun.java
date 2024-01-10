package week9;

import java.io.*;
import java.util.*;
public class 강의실배정 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 강의의 수
		int count = 1; // 강의실 개수
		
		int[][] lectures = new int[N][2];
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			lectures[i][0] = Integer.parseInt(st.nextToken());
			lectures[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬 
		Arrays.sort(lectures, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		// 우선순위 큐 -> 종료시각을 담음
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		// 첫 번째 강의의 종료시각
		pq.add(lectures[0][1]);
		// 큐의 원소(peek)의 종료시간과 i번 강의의 시작시간을 비교 -> 같은 강의실에서 들을 수 있는지 없는지
		// 같은 강의실에서 들을 수 없음 -> 큐에 추가
		// 같은 강의실에서 들을 수 있음 -> poll 하고 i 번 강의 큐에 추가
		// 최종적으로 큐에는 강의실 별로 하나의 원소만 남게될 것 -> 큐의 원소개수 = 필요한 강의실 개수
		for (int i = 1; i < N; i++)
		{
			// peek한 원소의 종료시각 <= i 번 강의 시작시간 -> 같은 강의실 사용 가능
			if(pq.peek() <= lectures[i][0]) 
				pq.poll();
			
			pq.add(lectures[i][1]);
		}
		System.out.println(pq.size());
	}
}
