import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        double max = 0;
        double[] arr = new double[N];
        for (int i = 0; i<arr.length; i++){
            arr[i] = Double.parseDouble(st.nextToken());
            if(arr[i] > max){
                max = arr[i];
            }
        }
        double answer= max;
        for (int i =0; i <arr.length; i++){
            if (arr[i] != max) answer += arr[i] / 2;
        }
        System.out.println(answer);
    }

}
