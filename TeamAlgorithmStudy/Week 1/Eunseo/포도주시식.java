import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int t = Integer.parseInt(s);
        int[] arr = new int[t + 1];
        for(int x = 0; x< t; x++) {
        	s = br.readLine();
        	arr[x] = Integer.parseInt(s);
        }
        int[] dp = new int[10001];
        if(t == 1) {
        	System.out.println(arr[0]);
        	return;
        }
        dp[0] = arr[0];
        if(t >= 2) {
        	dp[1] = arr[0] + arr[1];
        	int min = Math.min(arr[0], Math.min(arr[1], arr[2]));
        	dp[2] = arr[0] + arr[1] + arr[2] - min;
        }
        for(int i = 3; i <= t; i++) {
//포도주는 연속 3개를 먹을 수 없음. 
//이번 와인을 먹지 않는 경우 a
//이번 와인을 먹으면서, 2개 연속으로 먹는 경우와 이전것을 먹지 않는 경우 
//총 3개의 경우가 존재하므로, 그 경우들 중 최대값을 저장
        	int a = dp[i - 1];
        	int b = dp[i - 3] + arr[i-1] + arr[i];
        	int c = dp[i - 2] + arr[i];
        	dp[i] = Math.max(a, Math.max(b, c));
        }
        System.out.println(dp[t]);        
    }
}
