

import java.util.Scanner;

public class Main {

	static boolean []visit ;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main ma = new Main();
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		visit = new boolean[M+1];
		int [][] arr = new int[M+1][M+1];
		
		//정점 체크 후 연결선 1로 긋기
		for(int i = 0 ; i<  N ; i++) {
			int U = sc.nextInt();
			int V = sc.nextInt();
			
			arr[U][V]=1;
			arr[V][U]=1;
		}
		
		//방문하지 않았다면 방문
		for(int i = 1 ; i<  arr.length ; i++) {
			if(!visit[i]) {
				ma.BFS(arr, i);
				count++;
			}
		}
		System.out.print(count);
	}
	
	//BFS로 방문함
	public void BFS(int [][]arr , int i) {
		visit[i] = true;
		for(int j = 1; j <arr.length; j++) {
			if(!visit[j] && arr[i][j]== 1) {
				BFS(arr,j);
			}
		}
	}
}
