

import java.util.Scanner;

public class Main {
	static int [][] arr;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		arr = new int[num][num];
		
		for(int i = 0 ; i <num ; i++) {
			for(int j = 0 ; j <num ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//i에서 j까지 갈수 있는가?
		// i-> k, j->j
		for(int k = 0 ; k < num ; k++) {
			for(int i =0 ; i < num; i++) {
				for(int j =0; j < num ; j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}
		
		for(int i = 0 ; i < num ; i++) {
			for(int j = 0; j <num ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
