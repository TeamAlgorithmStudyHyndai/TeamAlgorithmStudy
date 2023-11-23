

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		int[] returnArr = new int[num];
		for(int i = 0 ; i< num ; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i< num ; i++) {
			int leftCnt = arr[i];
			//returnArr, 왼쪽에 남은사람, 총 사람수를 param으로 넘긴다
			int newPosition = findPoistion(returnArr ,leftCnt ,num);
			returnArr[newPosition] = i+1;
		}
		
		for(int i = 0 ; i< num ; i++) {
			System.out.print(returnArr[i]+ " ");
		}

	}

	private static int findPoistion(int[] lineArr, int leftCnt, int num) {
		
		for(int i = 0 ; i < num ; i++) {
			//왼쪽에 남은 사람수가 0명이고, 해당값이 0이라면 그 위치를 return한다.
			if(leftCnt == 0 && lineArr[i] == 0)
				return i;
			
			//아닐 경우에는 왼쪽에 남은사람수를 줄인다.
			if(lineArr[i] == 0)
				leftCnt--;
			
		}
		return -1;
	}

}
