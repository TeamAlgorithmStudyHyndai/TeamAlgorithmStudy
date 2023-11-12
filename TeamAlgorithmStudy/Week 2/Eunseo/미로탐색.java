import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n,m;
	static int[][] arr;
	static int[][] check;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static class tuple{
		int x;
		int y;
		int z;
		public tuple(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        check = new int[n][m];
        for(int i =0; i < n;i++) {
        	String s1 = br.readLine();
        	for(int j =0; j < s1.length(); j++) 
        		arr[i][j] = s1.charAt(j) -'0';
        }

        Queue<tuple> q = new LinkedList<>();
        q.offer(new tuple(0,0,0));
        int res = n * m;
        while(!q.isEmpty()) {
        	tuple t = q.poll();
        	int x = t.x;
        	int y = t.y;
        	int z = t.z;
        	if(x == n - 1 && y == m - 1) res = Math.min(res, z);
        	for(int i = 0; i<4; i++) {
        		int xx = x + dx[i];
        		int yy = y + dy[i];
        		if(isIn(xx,yy) && arr[xx][yy] == 1 && check[xx][yy] == 0) {
        			check[xx][yy] = 1;
        			q.offer(new tuple(xx,yy,z + 1));
        		}
        	}
        }
        System.out.println(res + 1);
    }
    public static boolean isIn(int x, int y) {
    	if(x >= 0 && x < n && y >= 0 && y < m) return true;
    	return false;
    }
}
