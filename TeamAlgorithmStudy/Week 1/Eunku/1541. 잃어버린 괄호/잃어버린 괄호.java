import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MAX_VALUE;
        while(minus.hasMoreTokens()){
            StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");
            int temp = 0;
            while(plus.hasMoreTokens()){
                temp += Integer.parseInt(plus.nextToken());
            }
            if (sum == Integer.MAX_VALUE) sum = temp;
            else sum -= temp;
        }
        System.out.println(sum);
    }
}