import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {
	static int[][] graph;
	static boolean[] marked;
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/* [입력] */
		// 첫째 줄에는 컴퓨터의 수가 주어진다
		int num = Integer.parseInt(br.readLine());
		// 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다
		int networks = Integer.parseInt(br.readLine());
		graph = new int[num + 1][num + 1];
		marked = new boolean[num + 1];
		
		// 이어서 한 줄에 한 쌍씩 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
		for (int i = 0; i < networks; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = graph[y][x] = 1;
		}
		
		/* [출력] */
		// 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 
		// 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
		DFS(graph, 1);
		System.out.println(count - 1);
		
	}
	
	static void DFS(int[][]graph, int v) {
		marked[v] = true;
		count++;
		for(int i = 0; i < graph.length; i++) {
			if (marked[i] == false && graph[v][i] == 1) {
				DFS(graph, i);
			}
		}
	}	
}
