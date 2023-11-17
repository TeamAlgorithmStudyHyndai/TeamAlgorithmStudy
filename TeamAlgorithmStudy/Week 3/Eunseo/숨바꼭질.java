import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] arr, check;
	static int n,m;
	static class xy{
		int x;
		int y;
		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        int res = -1;
        Queue<xy> q = new LinkedList<>();
        q.offer(new xy(n,0));
        check = new int[100001];
        while(!q.isEmpty()) {
        	xy tmp = q.poll();
        	int x = tmp.x;
        	if(x == m) res = res == -1 ? tmp.y : Math.min(res, tmp.y);
        	if(x - 1 >= 0 && check[x-1] == 0) {
    			check[x - 1] = 1;
    			q.offer(new xy(x-1, tmp.y + 1));
    		}
    		if(x + 1<= 100000 && check[x+1] == 0) {
    			check[x + 1] = 1;
    			q.offer(new xy(x + 1, tmp.y + 1));
    		}
    		if(x * 2 <= 100000 && check[x*2] == 0) {
    			check[x*2] = 1;
    			q.offer(new xy(x * 2, tmp.y + 1));
    		}
        }
        System.out.println(res);
	}
}