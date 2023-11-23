import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m,k;
    static int cnt;
    static Queue<Point> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x_1 = Integer.parseInt(st.nextToken());
            int y_1 = Integer.parseInt(st.nextToken());
            int x_2 = Integer.parseInt(st.nextToken());
            int y_2 = Integer.parseInt(st.nextToken());

            for(int j= x_1; j<x_2; j++){
                for(int z = y_1; z<y_2; z++){
                    map[z][j] = 1;
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] ==0 && !visit[i][j]){
                    list.add(bfs(new Point(i,j)));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int a: list) {
            System.out.print(a+ " ");
        }
    }
    static int bfs(Point p){
        cnt =1;
        visit[p.x][p.y] = true;
        que.offer(p);
        while(!que.isEmpty()){
            p = que.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x+dx[i];
                int y = p.y+dy[i];

                if(x<0 || x>=n || y<0 || y>=m) continue;

                if(!visit[x][y] && map[x][y] == 0){
                    visit[x][y] = true;
                    cnt++;
                    que.offer(new Point(x,y));
                }
            }
        }
        return cnt;
    }
}
