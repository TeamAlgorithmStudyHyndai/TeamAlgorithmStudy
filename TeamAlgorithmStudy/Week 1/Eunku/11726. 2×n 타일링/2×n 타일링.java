import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int[] dp;
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        System.out.println(solution(n));
    }
    static int solution(int n){
        if(dp[n]>0){
            return dp[n];
        }
        if (n ==1){
            return dp[1] =1;
        }
        if (n == 2){
            return dp[2] =2;
        }

        return dp[n] = (solution(n-1) + solution(n-2) )%10007;
    }
}
