

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][][] arr;  
    static boolean[][][] visited;  
    static int L, R, C;
    static int [] dx = {0,0,0,1,0,-1};
    static int [] dy = {0,0,1,0,-1,0};
    static int [] dz = {1,-1,0,0,0,0};
    static int data = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                return;
            }
            int startX = 0;
            int startY = 0;
            int startZ = 0 ;
            
            int endX = 0;
            int endY = 0;
            int endZ = 0;
            
            arr = new char[L][R][C];  
            visited = new boolean[L][R][C];  
            
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                    	arr[i][j][k] = line.charAt(k);
                    	
                    	if(arr[i][j][k] == 'S') {
                    		startX = i;
                    		startY = j;
                    		startZ = k;
                    	}else if(arr[i][j][k] == 'E') {
                    		endX = i;
                    		endY = j;
                    		endZ = k;
                    	}
                    }
                }
                br.readLine();
            }
            
            // bfs함수 실행
            bfs(startX,startY,startZ,endX,endY,endZ);
            
            if(data == -1) {
            	System.out.println("Trapped!");
            }else {
            	System.out.println("Escaped in "+data+" minute(s).");
            }
            data = -1;
        }
    }

	public static void bfs(int startX, int startY, int startZ, int endX, int endY, int endZ) {
		
		Queue<Point3> q = new LinkedList<Point3>();
		q.add(new Point3(startX, startY,startZ,1 ));
		visited[startX][startY][startZ] = true;
		
		while(!q.isEmpty()) {
			Point3 p = q.poll();
			
			for(int i = 0 ; i < 6 ; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				int nextZ = p.z + dz[i];
				
				
				
				if(nextX < 0 || nextY< 0 || nextZ < 0 || nextX>=arr.length || nextY>=arr[0].length || nextZ >= arr[0][0].length)
					continue;
				if(visited[nextX][nextY][nextZ] || arr[nextX][nextY][nextZ]== '#')
					continue;
				if(arr[nextX][nextY][nextZ] == 'E') {
					data = p.stairCnt;
					break;
				}
				visited[nextX][nextY][nextZ] = true;
				q.add(new Point3(nextX, nextY,nextZ, p.stairCnt+1));
			
			}
		}
	}
 
}

class Point3{
	int x;
	int y;
	int z;
	int stairCnt;
	
	public Point3(int x, int y, int z, int stairCnt) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.stairCnt = stairCnt;
	}
}

