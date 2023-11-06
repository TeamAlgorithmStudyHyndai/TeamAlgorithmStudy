import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        for(int i =0; i< n; i++) {
        	String s2 =br.readLine();
        	arr[i] = Integer.parseInt(s2);
        }
        int answer = 0;
        for(int i = n-1; i>=0; i--) {
        	while(k >= arr[i]) {
        		k -= arr[i];
        		answer++;
        	}
        }
        System.out.println(answer);
    }
}
