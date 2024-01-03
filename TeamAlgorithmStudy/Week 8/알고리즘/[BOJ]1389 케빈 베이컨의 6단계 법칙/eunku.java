import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                }else arr[i][j] = 100_000_000;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        for (int k = 0; k <N ; k++) {
            for (int i = 0; i <N ; i++) {
                for (int j = 0; j <N ; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int[] kb = new int[N];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                kb[i] += arr[i][j];
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if(kb[answer] > kb[i]){
                answer = i;
            }
        }
        System.out.println(answer+1);
    }
}
