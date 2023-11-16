import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] check;
	static int[][] arr;
	static int n, m, k;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int test = Integer.parseInt(br.readLine());
    	for(int t = 0; t < test; t++) {
    		String[] s = br.readLine().split(" ");
    		m = Integer.parseInt(s[0]);
    		n = Integer.parseInt(s[1]);
    		k = Integer.parseInt(s[2]);
    		arr = new int[n][m];
    		for(int i =0; i<k; i++) {
    			String[] s2 = br.readLine().split(" ");
    			int x = Integer.parseInt(s2[1]);
    			int y = Integer.parseInt(s2[0]);
    			arr[x][y] = 1;
    		}
    		check = new int[n][m];
    		int res = 0;
    		for(int i =0; i < n; i++) {
    			for(int j =0; j < m; j++) {
    				if(check[i][j] == 0 && arr[i][j] == 1) {
    					//System.out.println(i + "," + j);
    					res++;
    					dfs(i,j);
    				}
    			}
    		}
    		System.out.println(res);
    	}
	}
	public static void dfs(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(isIn(xx,yy) && check[xx][yy] == 0 && arr[xx][yy] == 1) {
				check[xx][yy] = 1;
				dfs(xx,yy);
			}
		}
	}
	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < m) return true;
		else return false;
	}
}
