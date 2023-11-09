import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;


    public static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ans = new int[Arrays.stream(arr).max().getAsInt() +1];

        for (int a : arr){
            System.out.println(solution(a));
        }
    }
    static int solution(int n){
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 4;

        for (int i = 4; i <n+1; i++){
            if(ans[i] == 0){
                ans[i] = ans[i-1] + ans[i-2] + ans[i-3];
            }
        }
        return ans[n];
    }
}
