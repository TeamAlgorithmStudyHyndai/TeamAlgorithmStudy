import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String [] strArr = str.split("-"); //문자열을 -에 따라 나눔.
		Main ma = new Main();
		int sum = 0;
		
		for(int i = 0 ; i <strArr.length ; i++) {
			if(i == 0)
				sum += ma.greedy(strArr[i]);
			else
				sum -= ma.greedy(strArr[i]);
		}
		
		System.out.println(sum);
	}
	public int greedy(String str) {
		String[] greedySumArr = str.split("\\+");
		int minusSum = 0;
		
		for(int i = 0 ; i < greedySumArr.length;i++) {
			minusSum+= Integer.parseInt(greedySumArr[i]);
		}
		return minusSum;	
	}
}
