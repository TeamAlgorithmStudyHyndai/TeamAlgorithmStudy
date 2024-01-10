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
        int answer=0;
        int left =0;
        int right =0;
        int[] count = new int[100001];
        count[arr[right]]++;
        while (left < N){
            if(count[arr[right]] <= K ){
                answer = Math.max(answer, right - left+1);
            }

            if(count[arr[right]] > K || right ==N-1){
                count[arr[left]]--;
                left++;
            } else{
//                answer = Math.max(answer, right - left+1);
                right++;
                count[arr[right]]++;
            }

        }
        return answer;
    }
}
