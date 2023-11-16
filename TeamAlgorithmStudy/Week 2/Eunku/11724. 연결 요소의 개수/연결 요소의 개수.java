import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] con;
    static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        con = new int[N][N];
        visit = new boolean[N];
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            con[a-1][b-1] = 1;
            con[b-1][a-1] = 1;
        }
        int ans = 0;
        for (int i=0; i<N; i++){
            if(!visit[i]){
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }
    public static void dfs(int n){
        visit[n] = true;
        for (int i =0; i<N; i++){
            if(con[n][i] ==1 && !visit[i]){
                dfs(i);
            }
        }
    }
}
