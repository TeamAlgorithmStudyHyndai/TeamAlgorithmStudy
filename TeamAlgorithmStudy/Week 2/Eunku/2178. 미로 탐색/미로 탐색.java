import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static int[][] distance;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0,0));
        distance[0][0] = 1;
        while(!que.isEmpty()){
            Point p = que.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x+dx[i];
                int y = p.y+dy[i];
                if(x<0 || x>=N || y<0 || y>=M) continue;

                if(map[x][y] ==1 && !visit[x][y]){
                    visit[x][y] = true;
                    distance[x][y]= distance[p.x][p.y] + 1;
                    que.offer(new Point(x,y));
                }
            }

        }
        System.out.println(distance[N-1][M-1]);
    }
}
