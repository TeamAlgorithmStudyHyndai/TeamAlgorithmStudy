

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int [][] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		arr = new int[num][2];
		
		for(int i= 0; i < num ; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int data = greedy(arr);
		System.out.println(data);
		
	}
	public static int greedy(int[][] arr) {
		//정렬
		Arrays.sort(arr, new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0]-o2[0];
			}	
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//종료시간의 첫번째 값 넣기
		pq.add(arr[0][1]);
		
		for(int i = 1 ; i <arr.length ; i++) {
			int start = arr[i][0];
			int end = arr[i][1];
		
			//만약 n번째 시작시간이, n-1 종료시간보다 작은 경우
			if(pq.peek() <= start ) {
				pq.poll();
			}
			pq.add(end);
		}

		return pq.size();
	}
}
