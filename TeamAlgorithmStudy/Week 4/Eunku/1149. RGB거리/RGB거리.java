import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] price;

    static int[][] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        price = new int[N][3];
        DP= new int[N][3];
        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<3; j++){
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DP[0][0] = price[0][0];
        DP[0][1] = price[0][1];
        DP[0][2] = price[0][2];
        System.out.print(solution( 1));


    }
    public static int solution(int depth){


        for (int i=0; i<3; i++){
            if (i==0){
                DP[depth][i] = Math.min(DP[depth-1][i+1], DP[depth-1][i+2]) + price[depth][i];
            }
            else if (i==1){
                DP[depth][i] = Math.min(DP[depth-1][i+1], DP[depth-1][i-1]) + price[depth][i];
            }
            else {
                DP[depth][i] = Math.min(DP[depth-1][i-1], DP[depth-1][i-2]) + price[depth][i];
            }

        }

        if (depth ==N-1) return Math.min(Math.min(DP[depth][0], DP[depth][1]), DP[depth][2]);
        
        return solution(depth + 1);
    }


}
