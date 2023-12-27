package week7;

import java.util.*;
import java.io.*;
public class 물통 {
	static Set<Integer> result = new HashSet<Integer>();
	static int A, B, C;
	static int[] bottles;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 각각 부피가 A, B, C(1 ≤ A, B, C ≤ 200) 리터인 세 개의 물통이 있다
		// 처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터) 차 있다.
		A = Integer.parseInt(st.nextToken()); 
		B = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		
		bottles = new int[3];
		bottles[0] = A;
		bottles[1] = B;
		bottles[2] = C;
		
		bfs();
		
		// 정렬
		List<Integer> list = new ArrayList<>(result);
		Collections.sort(list);
		
		// 출력
		for (int i = 0; i < list.size(); i++)
		{
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	static void bfs()
	{
		Queue<int[]> que = new LinkedList<>();
		visited = new boolean[A + 1][B + 1][C + 1];
		// 초기값
		que.add(new int[] {0, 0, C});
		visited[0][0][C] = true;
		result.add(C);
		
		while(!que.isEmpty())
		{
			int[] cur = que.poll();
			
			// A = 0 일 떄마다 C의 값을 result 에 저장
			if (cur[0] == 0)
				result.add(cur[2]);
			
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					if (i == j)
						continue;
					int[] next = moveWater(cur, i, j);
					if(visited[next[0]][next[1]][next[2]] == false)
					{
						visited[next[0]][next[1]][next[2]] = true;
						que.add(next);
					}
				}
			}
		} // end while
	}
	
	// from -> to 로 물 옮긴 후 배열 반환
	static int[] moveWater(int[] now, int from, int to)
	{
		int[] next = now.clone();
		
		if (now[from] + now[to] <= bottles[to]) // 다 옮길 수 있으면
		{
			next[to] += now[from];
			next[from] = 0;
		}
		else // 다 못옮기면
		{
			next[to] = bottles[to];
			next[from] = (now[from] + now[to]) - bottles[to];
		}
		return next;
	}
}
