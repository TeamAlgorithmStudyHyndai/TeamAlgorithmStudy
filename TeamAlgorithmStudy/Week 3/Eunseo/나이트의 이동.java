import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int[] dx = {1,2,2,1,-2,-1,-2,-1};
	static int[] dy = {2,1,-1,-2,-1,-2,1,2};
	static int n;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int t = 0; t < test; t++) {
        	n = Integer.parseInt(br.readLine());
        	String[] xy = br.readLine().split(" ");
        	int x_knight = Integer.parseInt(xy[0]);
        	int y_knight = Integer.parseInt(xy[1]);
        	xyz knight = new xyz(x_knight,y_knight,0);
        	String[] dest = br.readLine().split(" ");
        	int desX = Integer.parseInt(dest[0]);
        	int desY = Integer.parseInt(dest[1]);
        	
        	Queue<xyz> q = new LinkedList<>();
        	q.offer(knight);
        	int res = -1;
        	boolean[][] check = new boolean[n][n];
        	while(!q.isEmpty()) {
        		xyz current_knight = q.poll();
        		int x = current_knight.x;
        		int y = current_knight.y;
        		int cnt = current_knight.z;
        		if(x == desX && y == desY)
        			res = res==-1 ? cnt : Math.min(res, cnt);
        		for(int i =0; i< 8; i++) {
        			int xx = x + dx[i];
        			int yy = y + dy[i];
        			if(isIn(xx,yy) && !check[xx][yy]) {
        				check[xx][yy] = true;
        				q.offer(new xyz(xx,yy,cnt + 1));
        			}
        		}
        	}
        	System.out.println(res);
        }
      
	}
	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < n) return true;
		return false;
	}
}