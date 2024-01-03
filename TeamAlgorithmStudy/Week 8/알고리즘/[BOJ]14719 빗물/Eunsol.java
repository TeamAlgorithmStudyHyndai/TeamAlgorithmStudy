
import java.util.Scanner;

public class Main {

	static int[]arr;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		arr = new int[W];

		for(int i = 0 ; i < W ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		for(int i = 1; i < W-1; i++) {
			int left = leftSide(i);
			int right = rightSide(i);
			
			int minHeight = Math.min(left, right);
			
			if(minHeight != 0) {	
				sum += (minHeight - arr[i]) >= 0 ? (minHeight - arr[i]): 0;
			}
		}
		System.out.println(sum);
	}
	private static int leftSide(int std) {
		int max = 0;
		
		for(int i = std-1; i >= 0 ;i --) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}
	private static int rightSide(int std) {
		int max = 0;
		
		for(int i = std+1; i < arr.length ; i++) {
			max = Math.max(max, arr[i]);
		}
		
		return max;
	}

}
