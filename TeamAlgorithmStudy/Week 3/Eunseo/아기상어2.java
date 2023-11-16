import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class xyz{
		int x;
		int y;
		int z;
		public xyz(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {1,1,0,-1,-1,-1,0,1};
	static int n, m;
    static int[][] res, arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        
        arr = new int[n][m];
        for(int i = 0; i< n; i++) {
        	String[] s = br.readLine().split(" ");
            for(int j =0; j< m; j++)
            	arr[i][j] = Integer.parseInt(s[j]);
        }
        
        res = new int[n][m];
        for(int i =0; i < n; i++)
        	Arrays.fill(res[i], -1);
        for(int i = 0; i< n; i++) {
            for(int j =0; j< m; j++) {
            	bfs(i,j);
            }
        }  
        int max = -1;
        for(int i = 0; i< n; i++) {
            for(int j =0; j< m; j++) {
            	max = Math.max(max, res[i][j]);
            }
        }    
        System.out.println(max);
	}
	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < m) return true;
		return false;
	}
	public static void bfs(int i, int j) {
		Queue<xyz> q = new LinkedList<>();
		q.offer(new xyz(i,j,0));
		boolean[][] check = new boolean[n][m];
		while(!q.isEmpty()) {
			xyz tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int z = tmp.z;
			if(arr[x][y] == 1) 
				res[i][j] = res[i][j] == -1 ? z : Math.min(res[i][j], z);
			for(int k =0; k<8; k++) {
				int xx = x + dx[k];
				int yy = y + dy[k];
				if(isIn(xx,yy) && !check[xx][yy]) {
					check[xx][yy] = true;
					q.offer(new xyz(xx,yy, z + 1));
				}
			}
		}
	}
}
