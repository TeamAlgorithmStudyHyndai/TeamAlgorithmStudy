
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Main {
	static int n,m;
	static int[][] arr;
	static Vector<xy> tomato; //익은 토마토 위치 저장
	static int[][] check;
	static int num; // 익은 토마토 개수;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static class xy{
		int x;
		int y;
		int z;
		public xy(int x, int y, int z) {
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
        arr = new int[m][n];
        check = new int[m][n];
        tomato = new Vector<>();
        num = 0;
        int numOfminus =0;
        for(int i =0; i < m; i++) {
        	String[] s2 = br.readLine().split(" ");
        	for(int j =0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(s2[j]);
        		if(arr[i][j] == 1) {
        			xy temp = new xy(i,j, 0);
        			tomato.add(temp);
        			check[i][j] = 1;
        			num++;
        		}
        		if(arr[i][j] == -1) numOfminus++;
        	}
        }
        if(tomato.size() == 0) { //입력으로 들어온 익은 토마토가 0개일때
        	System.out.println(-1);
        	return;
        }
        if(num == n * m) { // 저장될 때부터 모든 토마토가 익어있는 상태
        	System.out.println(0);
        	return;
        }

        Queue<xy> q = new LinkedList<>();
 
        for(int i =0; i< tomato.size(); i++) 
        	q.offer(tomato.get(i)); //익은 토마토 위치 저장
        int day = 0;
        while(!q.isEmpty()) {
        	xy temp = q.poll();
        	int x = temp.x;
        	int y = temp.y;
        	int z = temp.z; //익은 날짜
        	day = z;

        	for(int i =0; i< 4; i++) {
        		int xx = x + dx[i];
        		int yy = y + dy[i];
        		if(isIn(xx,yy) && check[xx][yy] == 0 && arr[xx][yy] == 0) {
        			num++;
        			check[xx][yy] = 1;
        			xy putXY = new xy(xx, yy, z + 1);
        			q.offer(putXY);
        		}
        	}
        }
        if(num + numOfminus != n * m) 
        	System.out.println(-1);
        else 
        	System.out.println(day);
//        for(int i =0; i < m; i++) 
//        	System.out.println(Arrays.toString(arr[i]));
//        for(int i =0; i< tomato.size(); i++) 
//        	System.out.println(tomato.get(i).x + "/" + tomato.get(i).y);
        
    }
    public static boolean isIn(int x, int y) {
    	if(x >= 0 && x < m && y >= 0 && y < n) return true;
    	return false;
    }
}

