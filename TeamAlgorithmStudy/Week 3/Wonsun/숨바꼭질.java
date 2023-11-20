package week3;
import java.io.*;
import java.util.*;
public class 숨바꼭질 {
	static int N; // 수빈이 위치 (0 ≤ N ≤ 100,000)
	static int K; // 동생 위치
	static final int MAX_SIZE = 100001; // 100000 -> 런타임에러뜸
	static int[] nextDir = {-1, 1};
	static boolean[] visited;
	static class Location{
		int loc;
		int time;
		public Location(int l, int t) {
			this.loc = l;
			this.time = t;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0;	// 동생을 찾는데 걸리는 시간
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[MAX_SIZE];
		
		// BFS
		Queue<Location> que = new LinkedList<>();
		que.add(new Location(N, 0));
		visited[N] = true;
		while(!que.isEmpty())
		{
			Location cur = que.poll();
			if (cur.loc == K) 
			{
				result = cur.time;
				break;
			}
			for (int i = 0; i < 3; i++)
			{
				int next = 0;
				if(i <= 1) 
				{
					next = cur.loc + nextDir[i];
				}
				else if (i == 2)
				{
					next = cur.loc * 2;
				}
				if (next < 0 || next >= MAX_SIZE) continue; // 범위 체크
				if (visited[next] == true) continue;
				visited[next] = true;
				que.add(new Location(next, cur.time + 1));
			}
		} // end while loop
		System.out.println(result);
	}
}
