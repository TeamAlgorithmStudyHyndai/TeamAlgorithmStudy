import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] day;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken()); // 6
        n = Integer.parseInt(st.nextToken()); // 4

        map = new int[n][m];
        day = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 받기
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    que.offer(new Point(i, j));
                }
            }
        }
        int max = 0;
        while(!que.isEmpty()){
            Point p = que.poll();
            for(int i =0; i<4; i++){
                int x = p.x+dx[i];
                int y = p.y+dy[i];

                if(x<0 || x>=n || y<0 || y>=m) continue;

                if(map[x][y] ==0 && day[x][y] ==0){
                    map[x][y] = 1;
                    day[x][y] = day[p.x][p.y] +1;
                    max = Math.max(max,day[x][y]);
                    que.offer(new Point(x,y));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] ==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);
    }
}
