import java.util.Scanner;

public class Test {
	
	// 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
	// 상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다
	// 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성
	public static void main(String[] args) {
		/* [입력] */
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); //첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
		
		/* [출력] */
		// 상근이가 배달하는 봉지의 최소 개수를 출력한다. 
		// 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
		System.out.println(howMany(n));
	}
	
	// 상근이는 귀찮기 때문에 최대한 적은 봉지로 들고 가려 한다
	// => 5킬로그램 봉지 위주로 들고가야 한다
	static int howMany(int n) {
		int s3 = 0; // 3kg 개수
		int s5 = n / 5; // 5kg 개수 초기값
		int remainder; //5kg 짜리로 채우고 남은 나머지
		
		
		// (1) 5의 배수면 바로 5로 나눈 몫 리턴
		if(n % 5 == 0)
		{
			return (n / 5);
		}
		// (2)
		while (s5 >= 0)
		{
			remainder = n - (5 * s5); //5kg 짜리로 채우고 남은 나머지
			if(remainder % 3 == 0)
			{	// 나머지가 3의 배수면
				s3 = remainder / 3;
				return (s3 + s5);
			}
			// 나머지가 3으로 나누어 떨어지지 않으면
			// 
			s5--;
		}
		// (3) 5kg 짜리와 3kg 짜리를 섞는건 답이없다
		// -> 3으로 나눠떨어지는지 확인
		if (n % 3 == 0)
		{
			return (n / 3);
		}
		
		// 가능한 모든 경우를 탐색했지만 N킬로그램을 만들 수 었었다
		return -1;
	}
}