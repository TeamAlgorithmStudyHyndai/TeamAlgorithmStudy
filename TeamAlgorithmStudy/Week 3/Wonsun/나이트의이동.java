package week3;

import java.io.*;
import java.util.*;

public class 나이트의이동 {
	static int L;
	static int[][] table; // 체스판
	static boolean[][] visited; // 방문여부
	static int[][] direction = {{2,1}, {1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2, -1}}; 
	static class Node{
		int y;
		int x;
		int count; // 움직인 횟수
		
		public Node(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.count = c;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/* 입력 */
		int T = Integer.parseInt(br.readLine()); // test case 개수
		// test case 의 개수 만큼 loop
		for (int i = 0; i < T; i++)
		{
			L = Integer.parseInt(br.readLine());
			table = new int[L][L];
			// 나이트의 현재 위치
			st = new StringTokenizer(br.readLine());
			int curY = Integer.parseInt(st.nextToken());
			int curX = Integer.parseInt(st.nextToken());
			// 이동하려고 하는 칸
			st = new StringTokenizer(br.readLine());
			int destY = Integer.parseInt(st.nextToken());
			int destX = Integer.parseInt(st.nextToken());
			table[destY][destX] = 1; 
			
			int answer = move(curY, curX); // BFS
			System.out.println(answer);
		}
	}
	
	// 나이트의 이동(BFS)
	static int move(int y, int x) {
        boolean[][] visited = new boolean[L][L];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(y, x, 0));
        visited[y][x] = true;
        int count = 0;
        
        while (!que.isEmpty()) {
            Node currentNode = que.poll(); // 현재 노드 poll
            for (int i = 0; i < direction.length; i++) 
            {	// 8방향 loop
                int nextY = currentNode.y + direction[i][0];
                int nextX = currentNode.x + direction[i][1];

                // 배열 범위 잘못 참조하는 -> 스킵
                if (rangeCheck(nextY, nextX) == false) continue;
                // 이미 방문한 노드 -> 스킵
                if (visited[nextY][nextX]) continue;
                // 다음 이동으로 끝나면
                if (table[nextY][nextX] == 1) return currentNode.count + 1;

                // 다음 경우 탐색
	            visited[nextY][nextX] = true;
	            que.add(new Node(nextY, nextX, currentNode.count + 1));
            } // end for loop
        } // end while loop
        
        return 0;
    }
	
	 static boolean rangeCheck(int y, int x) {
	        return (y >= 0 && x >= 0 && y < L && x < L);
	    }
}
