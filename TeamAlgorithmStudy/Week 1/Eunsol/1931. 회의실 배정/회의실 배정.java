import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Main ma = new Main();
		int num = sc.nextInt();
		int [][] arr = new int[num][2];
		
		
		for(int i =0 ; i < num ; i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			arr[i][0] = start;
			arr[i][1] = end;
		}
		System.out.println(ma.greedy(arr));

	}
	public int greedy(int [][] arr) {
	
		int cnt = 0 ;
		
		Arrays.sort(arr, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				else
					return o1[1]-o2[1];
			}	
		});
		int startTime = 0;
		int endTime =  0;
		for(int i =0 ; i < arr.length ; i++){
			if((arr[i][1] == endTime && (endTime-startTime)>(arr[i][1] -arr[i][0]))
				 ) {
				endTime = arr[i][1];
				startTime = arr[i][0];		
			}
			
			if(arr[i][0] >= endTime) {
				startTime = arr[i][0];
				endTime = arr[i][1];
				cnt++;
			}
				
		}
		return cnt;
		
		
	}
	
}
