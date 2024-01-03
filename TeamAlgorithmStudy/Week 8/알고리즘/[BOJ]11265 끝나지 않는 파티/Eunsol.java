

import java.util.Scanner;

public class Main {
	
	static int [][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[N][N];
		
		int M = sc.nextInt();
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		/*
		  입력받을때마다 플루이드 워셜 실행하면 시간 초과 발생함.
		  한번 플루이드 워셜 알고리즘을 실행한 후에, 값 비교하기
		 */
		minRoute();
		
		for(int i = 0 ; i < M ; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			
			if(arr[A-1][B-1] <= C)
				System.out.println("Enjoy other party");
			else {
				System.out.println("Stay here");
			}
		}
		
	}
	public static void minRoute(){
		for(int k = 0 ; k < arr.length; k++) {
			for(int i = 0 ; i< arr.length ; i++) {
				for(int j = 0 ; j <arr.length; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
	}

}
