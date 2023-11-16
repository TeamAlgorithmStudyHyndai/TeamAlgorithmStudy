
import java.io.*;
import java.util.*;

class Main {
    static boolean[] visit;
    static int[][] connect;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        connect = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int temp_a = Integer.parseInt(st.nextToken());
            int temp_b = Integer.parseInt(st.nextToken());
            connect[temp_a][temp_b] = 1;
            connect[temp_b][temp_a] = 1;
        }
        System.out.println(solution(1));

    }


    public static int solution(int n) {
        if (!visit[n]) {
            visit[n] = true;
            for (int i = 1; i < visit.length; i++) {
                if (connect[n][i] == 1 && !visit[i]) {
                    ans++;
                    solution(i);

                }
            }
        }
        return ans;
    }
}

