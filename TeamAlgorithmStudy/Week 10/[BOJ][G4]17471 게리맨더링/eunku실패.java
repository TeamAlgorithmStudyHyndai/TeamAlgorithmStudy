package Baekjoon.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek17471 {
    static int N;
    static int[][] arr;
    static int[] cnt;
    static boolean[] visit;

    static int all,ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = new int[N+1];
        all=0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N+1; i++) {
            int x = Integer.parseInt(st.nextToken());
            cnt[i] = x;
            all+=x;
        }
        arr = new int[N+1][N+1];
        visit = new boolean[N+1];
        for (int i = 1; i <N+1 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int temp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < temp; j++) {
                arr[i][Integer.parseInt(st.nextToken())] =1;
            }
        }
        ans = Integer.MAX_VALUE;
        for (int i = 1; i <N+1 ; i++) {
            dfs(0,0,i);
        }if (ans == Integer.MAX_VALUE){
            System.out.println(-1);
        } else{
            System.out.println(ans);
        }
    }
    public static void dfs(int depth, int sum, int start){
        if(depth == N) return;
        visit[start] = true;
        sum+=cnt[start];
        if(check(visit)) {
            ans = Math.min(ans, Math.abs(all-sum*2));
        }
        for (int i = 1; i <N+1 ; i++) {
            if(arr[start][i] ==1 && !visit[i]){
                dfs(depth +1, sum, i);
            }
        }
        visit[start] = false;
    }
    public static boolean check(boolean[] visit){
        int n = 0;
        boolean[] checks = visit.clone();
        for (int i = 1; i <N+1 ; i++) {
            if(!checks[i]) {
                n = i;
                break;
            }
        }
        Queue<Integer> que = new LinkedList<>();

        que.offer(n);
        checks[n] = true;
        while (!que.isEmpty()){
            int temp = que.poll();
            for (int i = 1; i <N+1 ; i++) {
                if(arr[temp][i] !=0 && !checks[i]){
                    que.offer(i);
                    checks[i] = true;
                }
            }
        }
        for (int i = 1; i <N+1 ; i++) {
            if(!checks[i]) return false;
        }
        return true;
    }
}
