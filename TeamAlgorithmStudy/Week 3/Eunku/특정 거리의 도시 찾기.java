import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k,x;

    static ArrayList<ArrayList<Integer>> map;
    static int[] distance;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        map = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            map.add(new ArrayList<>());
        }

        distance = new int[n+1];
        for (int i = 0; i <m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
        }

        bfs(x);
        boolean print = true;
        for (int i = 0; i < n+1; i++) {
            if(distance[i] ==k){
                System.out.println(i);
                print = false;
            }
        }
        if(print){
            System.out.println(-1);
        }
    }
    static void bfs(int x){
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        visit[x] = true;
        while (!que.isEmpty()){
            int temp = que.poll();
            ArrayList<Integer> list = map.get(temp);
            for (int i = 0; i < list.size(); i++) {
                int temp_1 = list.get(i);
                if(!visit[temp_1]){
                    visit[temp_1] = true;
                    distance[temp_1] = distance[temp] + 1;
                    que.add(temp_1);
                }
            }


        }
    }
}
