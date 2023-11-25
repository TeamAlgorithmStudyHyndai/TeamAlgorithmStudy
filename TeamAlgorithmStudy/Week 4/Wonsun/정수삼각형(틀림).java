package week5;

/* 삼각형위 맨 위 부터 아래로 내려가는 방식으로 구현한 코드 */
// 테스트케이스는 통과하지만 채점은 틀림
import java.io.*;
import java.util.*;
public class 정수삼각형 {
	static int[][] triangle;	//삼각형
	static List<Integer> sums; // 특정 깊이에서 나올 수 있는 합의 경우들
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		triangle = new int[N][];
		sums = new ArrayList<>();
		/* 삼각형 만들기*/
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int[] line = new int[i + 1];
			for (int j = 0; j < i + 1; j++)
			{
				line[j] = Integer.parseInt(st.nextToken());
			}
			triangle[i] = line;
		}
		
		sums.add(triangle[0][0]); // 초기값(7) 추가
		for(int i = 1; i < N; i ++)
		{
			sums = getNextSums(sums, i); // 한 층 내려갈 때마다 갱신
		}

		int max = 0;
		for (int i = 0 ; i < sums.size(); i++)
		{
			if(max < sums.get(i)) max = sums.get(i);
		}
		System.out.println(max);
	}
	
	// 기존 cases 와 다음 줄을 받아서 새로운 cases 로 갱신
	static List<Integer> getNextSums(List<Integer> sums, int nextIndex)	
	{
		List<Integer> newSums = new ArrayList<>();	// 리턴할 다음 경우의 수들
		int[] nextLine = triangle[nextIndex];		// 다음줄(배열)
		// sums 의 i번 원소 + nextLine[i] or nextLine[i+1] 
		for (int i = 0; i < sums.size(); i++)
		{
			for (int j = 0; j < 2; j++)
			{
				int index = i + j;
				if (index >= nextLine.length) continue;
				newSums.add(sums.get(i) + nextLine[index]);
			}
		}

		return newSums;
	}
	
}
