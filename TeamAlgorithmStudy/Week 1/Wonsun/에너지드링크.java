import java.util.Arrays;
import java.util.Scanner;

public class Test {
	/*
	 에너지 드링크의 양을 최대로 만드려면 ?
	 -> 두 개의 드링크 중 (양이 많은 것은 보존하고) (양이 적은 것을 버린다)
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int 	n; 		    // 가지고 있는 에너지드링크의 수
		int[] 	drinks; // 각 에너지 드링크의 양
		
		/* [ 입력 ] */
		n = scan.nextInt();
		drinks = new int[n];
		for (int i = 0; i < n; i++)
		{
			drinks[i] = scan.nextInt();
		}
		
		// 에너지 드링크의 양 정렬(오름차순)
		Arrays.sort(drinks);
		/* [ 출력 ] */
		// 첫째 줄에 페인이 최대로 만들 수 있는 에너지 드링크의 양을 출력한다.
		System.out.println(getMaxDrinks(drinks));
	
	}
	
	// 최대로 합쳐진 에너지 드링크의 양을 리턴하는 메소드
	static double getMaxDrinks(int[]drinks) {
		double  sum; // 리턴할 에너지 드링크의 합
		int 	len; // drinks[] 배열의 길이
		
		len = drinks.length;
		sum = drinks[len - 1]; //초기값 = 배열의 마지막 원소(가장 큰 값)
		for (int i = 0; i < len - 1; i++)
		{
			sum = combineDrinks(drinks[i], sum);
		}
		return sum;
	}
	
	// 두 개의 드링크를 합치는 메소드 , (큰거) + (작은거 / 2)
	static double combineDrinks(double small, double big) {
		//System.out.println("## " + big + " + " + small/2 + " = " + (big + small/2));
		return big + (small / 2);
	}
}
