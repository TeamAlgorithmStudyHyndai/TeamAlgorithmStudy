import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String temp = "";
        int answer = 0;
        boolean flag = true;//true -> + , false -> -
        // 마이너스가 나오는 순간, 뒤의 모든 수는 부호가 +이든 -이든 모두 뺄셈 연산이 가능
        //그러므로 첫번째 마이너스가 나오면 flag를 false로 만들고 뒤의 모든 연산을 뺄셈 연산.
        for(int i =0; i< s.length(); i++) {
        	if(s.charAt(i) == '-'|| s.charAt(i) == '+') {
        		if(flag) answer += Integer.parseInt(temp);
        		else answer -= Integer.parseInt(temp);
        		temp = "";
        		if(s.charAt(i) == '-') flag = false;
        	}
        	else temp += s.charAt(i);
        	if(i == s.length() -1) { 
        		if(flag) answer += Integer.parseInt(temp);
        		else answer -= Integer.parseInt(temp);
        	}
        	
        }
        System.out.println(answer);
    }
}
