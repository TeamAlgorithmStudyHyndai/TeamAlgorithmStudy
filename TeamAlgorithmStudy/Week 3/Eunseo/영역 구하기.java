import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Main {
	static class xyz{
		int x;
		int y;
		//int z;
		public xyz(int x, int y/*, int z*/) {
			this.x = x;
			this.y = y;
			//this.z = z;
		}
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int n,m;
	static int[][] arr, check;
	static Vector<Integer> v;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        arr = new int[m][n];
        check = new int[m][n];
        for(int i =0; i<k; i++) {
        	 String[] s1 = br.readLine().split(" ");
             int x1 = Integer.parseInt(s1[0]);
             int x2 = Integer.parseInt(s1[2]);
             int y1 = Integer.parseInt(s1[1]);
             int y2 = Integer.parseInt(s1[3]);
             
             for(int x = x1; x < x2; x++) {
            	 for(int y = y1; y < y2; y++) 
            		 arr[x][y] = 1;
             }    
        }
        v = new Vector<>();
        for(int x = 0; x < m; x++) {
        	for(int y = 0; y < n; y++) {
        		if(arr[x][y] == 0 && check[x][y] == 0) {
        			check[x][y] = 1;
        			//res++;
        			int ll =bfs(x,y);
        			v.add(ll);
        		}
         	}
        } 
        System.out.println(v.size());
        Collections.sort(v);
        for(int x = 0; x < v.size(); x++) 
        	System.out.print(v.get(x) + " ");
      
	}
	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < m && y >= 0 && y < n) return true;
		return false;
	}
	public static int bfs(int x, int y) {
		Queue<xyz> q = new LinkedList<>();
		q.offer(new xyz(x,y));
		int size = 0;
		while(!q.isEmpty()) {
			xyz temp = q.poll();
			size++;
			for(int i =0; i< 4; i++) {
				int xx = temp.x + dx[i];
				int yy = temp.y + dy[i];
				if(isIn(xx,yy) && check[xx][yy] == 0 && arr[xx][yy] == 0) {
					check[xx][yy] = 1;
					q.offer(new xyz(xx,yy));
				}
			}
		}
		return size;
	}
}