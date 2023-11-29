

import java.util.Scanner;

public class Main {
	static int [][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main ma = new Main();
		
		int num = sc.nextInt();
		
		arr= new int[num+2][num+2];
		
		for(int i = 1 ; i<num+1 ;i++) {
			for(int j = 1; j< i+1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	
		int max  = 0;
		 for(int i = 1 ; i<num+1 ;i++) {
			for(int j = 1; j< i+2; j++) {
				ma.DP(i,j);
				max= Math.max(max, arr[i][j]);
			}
		}
		 
		 System.out.println(max);
	}
	public void DP(int x, int y) {
		
		arr[x][y] += Math.max(arr[x-1][y-1], arr[x-1][y]);
	
	}
}