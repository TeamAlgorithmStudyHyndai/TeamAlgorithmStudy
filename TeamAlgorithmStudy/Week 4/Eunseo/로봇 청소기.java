import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n,m,r,c,d, res = 0;
	static int[] dx = {-1,0,1,0}; //북 동 남 서
	static int[] dy = {0,1,0,-1};
    static int[][] room;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s= br.readLine().split(" ");
        n = Integer.parseInt(s[0]);   
        m = Integer.parseInt(s[1]);

        String[] s1= br.readLine().split(" ");
        r = Integer.parseInt(s1[0]); 
        c = Integer.parseInt(s1[1]); 
        d = Integer.parseInt(s1[2]);
        
        room = new int[n][m];
        for(int i =0; i< n; i++) {
        	String[] s2 = br.readLine().split(" ");
        	for(int j =0; j<m; j++)
        		room[i][j] = Integer.parseInt(s2[j]);
        }
        cleaning(r,c,d);
        System.out.println(res);
        
    }

	public static void cleaning(int x, int y, int curD) {
		if(room[x][y] == 0) {// 벽: 1 / 청소X :0  / 청소O:2
			room[x][y] = 2; 
			res++;
		}
		int numOfdirty = 0;
		for(int i =0; i<4;i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(room[xx][yy] == 0) numOfdirty++;
		}
		if(numOfdirty == 0) { //2단계
			int dir = (curD + 2) % 4;
			int xx = x + dx[dir];
			int yy = y + dy[dir];
			if(room[xx][yy] == 1) 
				return;
			else
				cleaning(xx,yy,curD);
		}
		else { //3단계
			int dir =curD,xx,yy;
			for(int i =0; i<4; i++){
				dir = (dir + 3) % 4;
				xx = x + dx[dir];
				yy = y + dy[dir];
				if(room[xx][yy] == 0) {
					cleaning(xx,yy,dir);
					return;
				}
			}
		}
	}
}
