import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;

public class Main {
	static int[][] check;
	static int[][] arr;
	static int n;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int cnt;
	static Vector<Integer> v; 
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n][n];
    	check = new int[n][n];
    	for(int i =0; i< n; i++) {
    		String s = br.readLine();
    		for(int j = 0; j< n; j++)
    			arr[i][j] = s.charAt(j) - '0';
    	}
    	int res = 0;
    	v = new Vector<>();
    	int cnt = 1;
    	for(int i =0; i <n; i++) {
			for(int j =0; j <n; j++) {  
				if(check[i][j] == 0 && arr[i][j] == 1) {
					res++;
					cnt++;
					check[i][j] = 1;
					arr[i][j] = cnt;
					dfs(i,j, cnt);
				}
			}
		}
    	System.out.println(res);
    	int[] temp = new int[cnt + 1];
    	for(int i =0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(arr[i][j] >= 2) temp[arr[i][j]]++;
    		}
    	}
    	Arrays.sort(temp);
    	for(int i = 2; i<= cnt; i++)
    		System.out.println(temp[i]);
	}
	public static void dfs(int x, int y, int cnt) {
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(isIn(xx,yy) && check[xx][yy] == 0 && arr[xx][yy] == 1) {
				check[xx][yy] = 1;
				arr[xx][yy] = cnt;
				dfs(xx,yy, cnt);
			}
		}
	}
	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < n) return true;
		else return false;
	}
}
