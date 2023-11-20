
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int n, m, res= 0;
	static int[][] check;
	static char[][] arr;
	static int[] alphabet = new int[26];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		arr = new char[n][m];
		check = new int[n][m];
		for(int i =0; i<n; i++) {        
			String str = br.readLine();
			for(int j =0; j< m; j++)
				arr[i][j] = str.charAt(j);
		}

		check[0][0] = 1;
		alphabet[arr[0][0]-'A'] = 1;
		checking(0,0,1,arr[0][0]-'A');
		System.out.println(res);
	}
	public static void checking(int x, int y, int cnt, int idx) {
		//현재 좌표 , 칸 수, 직전에 이동한 알파벳 값
		if(alphabet[idx] == 2) {
			res = Math.max(cnt - 1, res);
			return;
		}
		for(int i =0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(isIn(xx,yy)&&check[xx][yy] == 0) {
				check[xx][yy] = 1;
				alphabet[arr[xx][yy]-'A'] += 1;
				checking(xx,yy,cnt+1, arr[xx][yy] - 'A');
				alphabet[arr[xx][yy]-'A'] -= 1;
				check[xx][yy] = 0;
			}
		}
		res = Math.max(cnt, res); //중복되는 경우가 없을때
	}
	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < m) return true;
		return false;
	}
}