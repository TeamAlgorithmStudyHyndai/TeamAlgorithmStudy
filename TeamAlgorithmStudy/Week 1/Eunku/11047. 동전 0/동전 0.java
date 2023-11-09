import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i<arr.length; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = N-1; i>=0; i--){
            int x = K / arr[i];
            cnt += x;
            K = K-x*arr[i];
            if(K == 0){
                break;
            }
        }
        System.out.println(cnt);


    }

}
