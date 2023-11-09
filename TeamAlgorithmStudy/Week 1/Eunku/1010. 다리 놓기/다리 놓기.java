import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;

        }
        for (int i=0; i<N; i++){
            System.out.println(solution(arr[i][0], arr[i][1]));
        }


    }
    static long solution(int a, int b){
        int x = b-a;
        if (x < a) a = x;
        long m = 1;
        long n = 1;
        for (int i = 0; i<a; i++){
            m = m * (b - i);
            n = n * (a - i);
        }


        return m / n;
    }
}
