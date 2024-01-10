import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,x,y,z; // z =0이면 안부숨, z=1이면 이미 부수고 지나옴
    static int[][] map;
    static int[][] route;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        route = new int[N][M];
        route[0][0] = 1;
        visited[0][0] = true;
        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(strings[j]);
            }
        }
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0,0,0));
        while (!que.isEmpty()){
            Point temp = que.poll();
            z = temp.z;
            for (int i = 0; i < 4; i++) {
                x = temp.x + dx[i];
                y = temp.y + dy[i];

                if(x<0 || x >= N || y<0 || y >= M) continue;

                if(!visited[x][y] && map[x][y] == 0 && z==0){
                    visited[x][y] = true;
                    route[x][y] = route[temp.x][temp.y] +1;
                    que.offer(new Point(x,y,z));
                } else if (map[x][y] ==1 && z ==0) {
                    route[x][y] = route[temp.x][temp.y] +1;
                    que.offer(new Point(x,y,z+1));
                }
                if(z==1 && map[x][y] ==0){
                    if(route[x][y] ==0){
                        route[x][y] = route[temp.x][temp.y] +1;
                        que.offer(new Point(x,y,z));
                    } else if(route[x][y] <= route[temp.x][temp.y] +1){
                        continue;
                    }

                }
            }
            if(route[N-1][M-1] !=0) break;
        }
        System.out.println(route[N-1][M-1] ==0 ? -1 : route[N-1][M-1]);
    }
}
class Point{
    int x,y,z;
    public Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
