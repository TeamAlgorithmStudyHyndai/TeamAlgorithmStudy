package secondWeek;

import java.util.Scanner;

public class Coin0 {

public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Main co = new Main();
		
		int N = sc.nextInt();
		int totalMoney = sc.nextInt();
		
		int []nArr = new int[N];
		
		for(int i = 0 ; i<nArr.length; i++) {
			nArr[i] = sc.nextInt();
		}
		int data = co.greedy(totalMoney, nArr);
		System.out.println(data);
		
	}
	public int greedy(int totalMoney, int[] arr) {
		
		int maxIndex = 0;
		int count = 0;
		for(int i = 0 ; i < arr.length; i++) {
			if(totalMoney <= arr[i]) {	
				maxIndex = i-1;
				break;
			}
		}
		
		
	   for(int i = maxIndex; i>-1;i--) {
		   int div = totalMoney/arr[i];
		   totalMoney = totalMoney - div * arr[i];
		   count +=div;
		   if(totalMoney ==0 )
			   break; 
	   }
	   return count;
	}

}
