import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(n-- > 0) {
        	int x = Integer.parseInt(br.readLine());
        	if(x != 0) 
            	pq.offer(x);
          	else
        		if(pq.isEmpty()) System.out.println(0);
        		else System.out.println(pq.poll());
        }
  
    }
}
