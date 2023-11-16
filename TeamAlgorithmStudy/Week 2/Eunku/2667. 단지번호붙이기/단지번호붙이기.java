import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j <N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        LinkedList<Integer> ans = new LinkedList<>();
        Queue<Point> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                int temp = 0;
                if(map[i][j] == 1 && !visit[i][j]){
                    visit[i][j] = true;
                    que.offer(new Point(i,j));

                    while(!que.isEmpty()){

                        Point p = que.poll();
                        temp++;

                        for (int k = 0; k < 4; k++) {
                            int x = p.x+dx[k];
                            int y = p.y+dy[k];

                            if(x<0 || x>=N || y<0 || y>=N) continue;

                            if(map[x][y] ==1 && !visit[x][y]){
                                visit[x][y] = true;
                                que.offer(new Point(x,y));
                            }
                        }

                    }
                }
                if(temp != 0) ans.offer(temp);
            }
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for (int a : ans){
            System.out.println(a);
        }
    }
}
