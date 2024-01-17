import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C;
    static char[][][] map;
    static boolean[][][] visited;
    static int[][][] time;
    static int start_x,start_y,start_z;
    static int end_x,end_y, end_z;
    static int[] dx = {1, -1, 0,0,0,0};   // 동, 서, 남, 북, 상, 하
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            setting();
            if(L == 0) return;

            int ans = sol();

            if (ans ==0){
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in "+ ans + " minute(s)." );
            }
        }
    }
    public static void setting() throws IOException{
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if(L == 0) return;

        map = new char[L][R][C];
        visited = new boolean[L][R][C];
        time = new int[L][R][C];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                char[] tempChar = br.readLine().toCharArray();
                for (int k = 0; k < C; k++) {
                    if (tempChar[k] == 'S'){
                        start_x = j;
                        start_y = k;
                        start_z = i;
                    }
                    if (tempChar[k] == 'E'){
                        end_x = j;
                        end_y = k;
                        end_z = i;
                    }
                    map[i][j][k] = tempChar[k];
                }
            }
            br.readLine();
        }
    }
    public static int sol(){
        Point start = new Point(start_z, start_x, start_y);
        visited[start_z][start_x][start_y] = true;
        Queue<Point> que = new LinkedList<>();
        que.offer(start);
        while(!que.isEmpty()){
            Point pnt = que.poll();
            for (int i = 0; i < 6; i++) {
                int z = pnt.z + dz[i];
                int x = pnt.x + dx[i];
                int y = pnt.y + dy[i];
                if(check(x,y,z)) continue;

                if(map[z][x][y] == '.' && !visited[z][x][y]){
                    visited[z][x][y] = true;
                    time[z][x][y] = time[pnt.z][pnt.x][pnt.y] + 1;
                    que.offer(new Point(z,x,y));
                }
                if(map[z][x][y] == 'E'){
                    time[z][x][y] = time[pnt.z][pnt.x][pnt.y] + 1;
                    return time[z][x][y];
                }
            }
        }
        return time[end_z][end_x][end_y];
    }

    static class Point{
        int x,y,z;
        Point(int z, int x, int y){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static boolean check(int x, int y, int z){
        if(x <0||y<0||z<0|| x>= R || y>=C || z>= L){
            return true;
        } else return false;
    }
}
