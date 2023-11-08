import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s2 = br.readLine().split(" ");
        int n = Integer.parseInt(s);
        Integer[] arr = new Integer[n];
        for(int i =0; i<n; i++) arr[i] = Integer.parseInt(s2[i]);
        
        Arrays.sort(arr, Collections.reverseOrder());
        
       double answer = (double)arr[0];
       for(int i = 1; i <n; i++) {
    	   answer += (double)arr[i]/2;
       }
       System.out.println(answer);
        
    }
}
