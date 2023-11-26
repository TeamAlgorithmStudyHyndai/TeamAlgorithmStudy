import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static int n, m;
	static class xy{
		int point;
		int sec;
		public xy(int point, int sec) {
			this.point = point;
			this.sec = sec;
		}
	
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int res = -1;
        boolean[] check = new boolean[100001];
        PriorityQueue<xy> pq = new PriorityQueue<>(Comparator.comparing(o1 -> o1.sec));
        pq.offer(new xy(n,0));
        while(!pq.isEmpty()) {
        	int x = pq.peek().point;
        	int sec = pq.poll().sec;
        	check[x] = true;
        	if(x == m) res = res == -1 ? sec : Math.min(res, sec);
        	if( 2 * x <= 100000 && !check[2*x]) {
        		pq.offer(new xy(2 * x, sec));
        	}
        	if(x - 1 >= 0 && !check[x-1]) {
        		pq.offer(new xy(x - 1, sec + 1));
        	}
        	if( x + 1 <= 100000 && !check[x+1]) {
        		pq.offer(new xy(x + 1, sec + 1));
        	}
        }
        System.out.println(res);
    }
}
