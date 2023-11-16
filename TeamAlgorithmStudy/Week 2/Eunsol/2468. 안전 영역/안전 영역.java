

import java.util.Scanner;

public class Main {

	static boolean [][]check;
	static int safeArea = 0 ;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Main ma = new Main();
		
		int num = sc.nextInt();
		int [][] arr = new int[num][num];
		check = new boolean[num][num];
		int maxHeight = 0;
		
		for(int i= 0 ; i < num ; i++) {
			for(int j= 0 ; j < num ; j++) {
				arr[i][j]= sc.nextInt();
				if(maxHeight < arr[i][j])
					maxHeight= arr[i][j];
			}
		}
		int param = 0;
		int maxSafeArea=0 ;
		while(param<= maxHeight) {
			safeArea=0;
			for(int i= 0 ; i < num ; i++) {
				for(int j = 0 ; j <arr[0].length ;j++) {
					if(!check[i][j] && arr[i][j] > param) {
						ma.DFS(arr, i,j, param);
						++safeArea;
					}
				}
			}
			param++;
			maxSafeArea = Math.max(safeArea, maxSafeArea);
			check = new boolean[num][num];
		}
		System.out.println(maxSafeArea);
	}
	
	public void DFS(int[][] arr, int i, int j, int height) {
	    check[i][j] = true;

	    if (i - 1 >= 0 && arr[i - 1][j] > height && !check[i - 1][j]) {
	        DFS(arr, i - 1, j, height);
	    }
	    if (i + 1 < arr.length && arr[i + 1][j] > height && !check[i + 1][j]) {
	        DFS(arr, i + 1, j, height);
	    }
	    if (j - 1 >= 0 && arr[i][j - 1] > height && !check[i][j - 1]) {
	        DFS(arr, i, j - 1, height);
	    }
	    if (j + 1 < arr[0].length && arr[i][j + 1] > height && !check[i][j + 1]) {
	        DFS(arr, i, j + 1, height);
	    }
	}

}
