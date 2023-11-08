
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int answer =0;
//가능한 한 5kg짜리 봉투가 많은것이 좋음.
//당장의 이익을 위해 5의 배수가 되는 순간 5kg짜리 봉투를 사용
        while(n > 0) {
        	if(n % 5 == 0) {
        		answer += n / 5;
        		n = 0;
        	}
        	else {
        		n -= 3;
        		answer++;
        	}
        }
        if( n < 0) System.out.println(-1);
        else System.out.println(answer);
    }
}
