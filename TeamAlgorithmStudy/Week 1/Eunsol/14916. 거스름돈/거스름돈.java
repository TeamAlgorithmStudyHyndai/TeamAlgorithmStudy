

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Main ma = new Main();
		
		int num = sc.nextInt();
		System.out.println(ma.greedy(num));
		
	}

	public int greedy(int num) {
		int originalNum = num;
		
		if(num % 5 == 0)
			return num/5;
		
		for(int i = num/5 ; i > 0 ; i--) {
			num  = originalNum;
			num = num - 5*i;
			
			if((num%2) == 0)
				return i+ (num/2);
		}
		
		if(originalNum % 2 == 0)
			return originalNum/2;
		
		return -1;
		
	}

}
