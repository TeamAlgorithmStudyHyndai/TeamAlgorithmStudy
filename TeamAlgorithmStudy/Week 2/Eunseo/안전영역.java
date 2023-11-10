import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] check;
	static int[][] arr;
	static int n;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n][n];
    	for(int i =0; i< n; i++) {
    		String[] s = br.readLine().split(" ");
    		for(int j = 0; j< n; j++)
    			arr[i][j] = Integer.parseInt(s[j]);
    	}
    	//높이는 1이상 100 이하의 정수
    	int res = -1;
    	for(int i = 0; i<= 100; i++) {
        	check = new int[n][n];
    		for(int k =0; k< n; k++) {
        		for(int j = 0; j< n; j++) 
        			if(arr[k][j] <= i) check[k][j] = -1;      		
    		}
    		int temp = 0;
    		for(int k =0; k <n; k++) {
    			for(int j =0; j <n; j++) {  
    				if(check[k][j] == 0) {
    					temp++;
    					check[k][j] = 1;
    					dfs(k,j);
    				}
    			}
    		}
        	res = Math.max(res, temp);
    	}
    	System.out.println(res);
	}
	public static void dfs(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(isIn(xx,yy) && check[xx][yy] == 0) {
				check[xx][yy] = 1;
				dfs(xx,yy);
			}
		}
	}
	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < n) return true;
		else return false;
	}
}
