import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int answer = 0;
        
        while(n > 0) {
        	if(n % 5 == 0) {
        		answer += n/ 5;
        		n = 0;
        	}
        	else {
        		answer++;
        		n -=2;
        	}
        }
        if(n < 0)System.out.println(-1);
        else System.out.println(answer);
    }
}
