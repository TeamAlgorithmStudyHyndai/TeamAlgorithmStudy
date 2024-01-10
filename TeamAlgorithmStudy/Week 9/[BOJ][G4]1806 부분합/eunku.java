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
        System.out.println(solution(N, K, arr));
    }
    public static int solution(int N,int K,int[] arr){
        int answer=Integer.MAX_VALUE;
        int start =0;
        int end =0;
        int sum = 0;
        sum += arr[end];
        while (start < N){
            if(sum >= K){
                answer = Math.min(answer, end - start + 1);
            }
            if(sum >= K || end == N-1){
                sum -= arr[start];
                start++;
            } else {
                end++;
                sum += arr[end];

            }

        }

        return (answer == Integer.MAX_VALUE)? 0 : answer;
    }
}
