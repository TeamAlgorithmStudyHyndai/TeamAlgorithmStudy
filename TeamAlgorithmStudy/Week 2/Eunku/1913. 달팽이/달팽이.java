import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        int value = n*n;
        for (int i =0; i<n; i++){
            arr[i][0] = value--;
        }

        int temp_even = 1;
        int temp_odd = 1;

        for (int i = n-1; i>0; i--){
            if(i % 2 ==0){
                for(int j =0; j<i; j++){
                    arr[n-temp_even][j+temp_even] = value--;
                }
                for(int j =0; j<i; j++){
                    arr[n-j-temp_even-1][n-temp_even] = value--;
                }
                temp_even++;
            }

            if(i %2 != 0){
                for(int j =0; j<i; j++){
                    arr[temp_odd-1][n-j-temp_odd-1] = value--;
                }
                for(int j =0; j<i; j++){
                    arr[j+temp_odd][temp_odd] = value--;
                }
                temp_odd++;
            }

        }
        StringBuilder sb = new StringBuilder();
        int a =0;
        int b = 0;
        for(int i =0; i<n; i++){
            for(int j= 0; j<n; j++){
                sb.append(arr[i][j] + " ");
                if(j==n-1){
                    sb.append("\n");
                }
                if (arr[i][j] == m){
                    a = i+1;
                    b = j+1;
                }
            }
        }
        System.out.print(sb);
        System.out.println(a + " " + b);
    }
}
