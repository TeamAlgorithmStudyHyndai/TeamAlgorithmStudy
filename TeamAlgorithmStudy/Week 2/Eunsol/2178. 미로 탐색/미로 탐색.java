

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean [][] visited ;
	static int count = 0;
	static int []moveX = {0,0,1,-1};
	static int []moveY = {1,-1,0,0};
	
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 Main ma = new Main();
		 String[] dimensions = br.readLine().split(" ");
	     int N = Integer.parseInt(dimensions[0]);
	     int M = Integer.parseInt(dimensions[1]);
		  
		  int [][]arr = new int[N][M];
		  visited = new boolean[N][M];
		  
          for (int i = 0; i < N; i++) {
        	 String row = br.readLine();
        	 for (int j = 0; j < M; j++) {
        		arr[i][j]= Character.getNumericValue(row.charAt(j));
        	 }
          }
          br.close();
          
          visited[0][0]= true;
          ma.BFS(arr, 0,0);
        
          System.out.println(arr[N-1][M-1]);
	}
	public void BFS(int arr[][], int x, int y) {
		//초기 좌표 넣기
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i <4 ; i++) {
				int nextX = p.x +moveX[i];
				int nextY = p.y + moveY[i];
				
				//범위내에 index에 들어가는지 체크
				if(nextX <0 || nextY<0 || nextX >=arr.length || nextY >= arr[0].length) {
					continue;
				}
				//이미 방문한 점이거나, 경로가 없는 경우는 건너 뜀
				if(visited[nextX][nextY] || arr[nextX][nextY] == 0) {
					continue;
				}
				
				//다음으로 방문할 좌표 add하기
				q.add(new Point(nextX, nextY));
				arr[nextX][nextY]= arr[p.x][p.y]+1;
				visited[nextX][nextY] = true;
			}
		}
	}
	class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
			

}
