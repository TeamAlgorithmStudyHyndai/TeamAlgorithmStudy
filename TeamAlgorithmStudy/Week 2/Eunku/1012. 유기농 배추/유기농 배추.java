import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] cabbage; // 배추의 위치
    static boolean[][] visit; // 배추 방문 여부

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int x,y,k; // 가로, 세로, 배추 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans; // 횟수 카운트
        for (int i =0; i<n;i++){ // n번의 테스트 케이스
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cabbage = new int[x][y];
            visit = new boolean[x][y];
            for(int j =0; j< k; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int temp_x = Integer.parseInt(st.nextToken());
                int temp_y = Integer.parseInt(st.nextToken());
                cabbage[temp_x][temp_y] = 1; //배추 위치 저장하기
            }
            for(int j =0; j<x; j++){
                for(int a=0; a < y; a++){
                    if(cabbage[j][a] == 1 && !visit[j][a]){
                        ans++;
                        bfs(j,a);
                    }
                }
            }
            System.out.println(ans);
        }
    }
    static void bfs(int x, int y){
        if (!visit[x][y] && cabbage[x][y] == 1){
            visit[x][y] = true;
            for (int i=0; i<4; i++){
                if(x+dx[i] >=0 && x+dx[i] < visit.length && y+dy[i] >= 0 && y+dy[i] < visit[0].length){
                    if(cabbage[x+dx[i]][y+dy[i]] == 1 && !visit[x+dx[i]][y+dy[i]]) bfs(x+dx[i], y+dy[i]);
                }
            }
        }
    }
}
