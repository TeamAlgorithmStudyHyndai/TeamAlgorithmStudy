import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] rain;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        rain = new int[n][m];
        temp = new int[m];
        int x = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            x = Integer.parseInt(st.nextToken());
            temp[i] = x;
            sum += x;
            if (x != 0) {
                for (int j = n-1; j >= n-x; j--) {
                    rain[j][i] = 1;
                }
            }
        }
        int count =0;
        int left = 0;
        int countTemp =0;
        for (int i = 0; i < n; i++) {
            left = 0;
            countTemp=0;
            for (int j = 0; j < m; j++) {
                if(rain[i][j] == 0 && left == 0){
                    count++;
                } else if(rain[i][j] == 1 && left ==0){
                    left =1;
                } else if(rain[i][j] == 1 && left ==1){
                    countTemp = 0;
                } else if(rain[i][j] == 0 && left == 1){
                    countTemp++;
                }
            }
            if(rain[i][m-1] == 0) count += countTemp;
        }
        System.out.println(n*m - sum - count);
    }
}
