

import java.util.Scanner;

public class Main {

	static boolean [] check;
	static int count=-1;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Main ma = new Main();
		int num = sc.nextInt();
		int num2 = sc.nextInt();
		
		int[][] arr = new int[num+1][num+1];
		check  = new boolean[num+1];
		
		for(int i = 0; i < num2; i++) {
			int checkSpot = sc.nextInt();
			int checkSpot2 = sc.nextInt();
			arr[checkSpot][checkSpot2] = 1;
			arr[checkSpot2][checkSpot] = 1;
		}
		
		ma.BFS(arr, 1);
		
		System.out.println(count);
		
	}
	public void BFS(int[][] arr, int satrtNum) {
		
		check[satrtNum] = true;
		count++;
		for(int j = 1; j <arr.length ; j++) {
			if(!check[j]&& arr[ satrtNum][j] ==1) {
				
				BFS(arr, j);
			}
		}
	}

}
