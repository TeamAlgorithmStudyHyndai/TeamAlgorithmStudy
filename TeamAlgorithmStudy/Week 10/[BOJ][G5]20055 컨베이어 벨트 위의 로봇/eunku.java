import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,K,ans,cnt;
    static int[] arr;
    static boolean[] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[2*N];
        robot = new boolean[2*N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2*N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ans =0;
        cnt = 0;
        sol();
    }
    static void sol(){
        // 1번
        ans++;
        int end = arr[2*N-1];
        for (int i = 2*N-1; i >0; i--) {
            arr[i] = arr[i-1];
            robot[i] = robot[i-1];

        }
        robot[0] = false;
        arr[0] = end;
        if(robot[N-1]) robot[N-1] = false;
        // 2번
        for (int i = N-1; i >= 0; i--) {
            if(robot[i] && !robot[i+1] && arr[i+1] >= 1){
                robot[i] = false;
                robot[i+1] = true;
                arr[i+1]--;
                if(arr[i+1] ==0) cnt++;
            }
        }
        //3번
        if(arr[0] !=0){
            arr[0]--;
            robot[0] = true;
            if(arr[0] == 0) cnt++;
        }
        if(cnt >= K){
            System.out.println(ans);
        } else sol();
    }
}
