import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {
	static int n,m,k,x,res= 0;
//	static int[] dx = {0,1,1,1,0,-1,-1,-1};
//	static int[] dy = {1,1,0,-1,-1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);
		x = Integer.parseInt(s[3]);
		int[][] arr = new int[m][2];
		for(int i =0; i< m;i++) {
			String[] s1 = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s1[0]);
			arr[i][1] = Integer.parseInt(s1[1]);
		}
		int[] distance = new int[n + 1]; // 각 도시까지의 거리
		boolean[] check = new boolean[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> distance[o]));
		//거리가 짧은 순으로 우선순위
		distance[x] = 0;
		pq.offer(x);
		while(!pq.isEmpty()) {
			int u = pq.poll();
			if(check[u]) continue;
			if(distance[u] >= k) continue;
			//만약 이미 거리가 k 이상이라면 탐색 X -> 해당 코드 없으면 시간초과
			check[u] = true;
			for(int i =0; i< m; i++) {
				if(arr[i][0] == u &&
						!check[arr[i][1]] && 1 + distance[arr[i][0]] < distance[arr[i][1]]) {
					distance[arr[i][1]] = 1 + distance[arr[i][0]];
					pq.offer(arr[i][1]);
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i =1; i< distance.length; i++)
			if(k == distance[i]) list.add(i);
		Collections.sort(list);
		if(list.size() == 0) System.out.println(-1);
		else {
			for(int i =0; i< list.size();i++)
				System.out.println(list.get(i));
		}
	}
}