package week8;

import java.util.*;

public class Moo게임 {
	static int N;
	static char answer;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();

		charAtN(N);
		System.out.println(answer);
	}

	// S(N) 의 N 번째 글자 answer에 저장하는 메소드
	static void charAtN(int k) 
	{
		// 초기값 S(0)
		int length = 3;
		int index = 0;

		if (k == 1) 
			answer = 'm';
		else if (k <= 3)
			answer = 'o';
		else 
		{
			while (length < k) 
			{
				length = length * 2 + index + 4;
				index++;
			}

			// S(k - 1) 의 길이
			int sLen = (length - index - 3) / 2;

			if (length - sLen + 1 <= k) 
				charAtN(k - length + sLen);
			else if (k == sLen + 1)
				answer = 'm';
			else
				answer = 'o';
		}

	}
}
