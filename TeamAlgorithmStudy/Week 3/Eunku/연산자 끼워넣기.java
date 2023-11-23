import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,max,min;
    static int[] arr;
    static int[] math; // + - / *
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        math = new int[4];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < 4; i++) {
            math[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        sol(0,arr[0]);
        System.out.println(max);
        System.out.println(min);

    }
    static void sol(int depth, int sum){

        if(depth == N-1){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(math[i] ==0) continue;
            if(i==0){
                math[i]--;
                sol(depth+1, sum + arr[depth + 1]);
                math[i]++;
            } else if(i==1){
                math[i]--;
                sol(depth+1, sum- arr[depth + 1]);
                math[i]++;
            } else if (i==2) {
                math[i]--;
                sol(depth+1, sum*arr[depth + 1]);
                math[i]++;
            } else if (i==3) {
                math[i]--;
                sol(depth+1, sum / arr[depth + 1]);
                math[i]++;
            }
        }

    }

}
