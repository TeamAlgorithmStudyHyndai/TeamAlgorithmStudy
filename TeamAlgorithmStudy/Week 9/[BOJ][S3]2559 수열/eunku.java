import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N,K,arr));
    }
    public static int solution(int N, int K, int[] arr){
        int sum = 0;
        int answer = 0;

        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        answer = sum;
        for (int i = 0; i < N-K; i++) {
            sum = sum-arr[i] + arr[i+K];
            answer = Math.max(sum, answer);
        }
        
        return answer;
    }
}
