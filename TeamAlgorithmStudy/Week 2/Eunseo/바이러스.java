import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int computer, group;
	static int[] check;
	static pair[] arr;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	computer = Integer.parseInt(br.readLine());
    	group = Integer.parseInt(br.readLine());
    	arr = new pair[group]; 
    	check = new int[computer + 1];
    	for(int i = 0; i< group; i++) {
    		String[] s = br.readLine().split(" ");
    		int x = Integer.parseInt(s[0]);
    		int y = Integer.parseInt(s[1]);
    		pair p = new pair(x, y);
    		arr[i] = p;
    	}
    	for(int i =0; i< group; i++) {
    		pair p = arr[i];
    		if(p.x == 1 && check[p.y]== 0 ) {
    			check[p.y] = 1;
    			dfs(p.y);
    		}
    		if(p.y == 1 && check[p.x]== 0 ) {
    			check[p.x] = 1;
    			dfs(p.x);
    		}
    	}
    	int res = -1;
    	for(int i = 1; i <= computer; i++) {
    		if(check[i] == 1) res++;
    	}
    	if(group == 0) System.out.println(0);
    	else System.out.println(res);
	}
	public static void dfs(int pc) {
		for(int i = 0; i < group; i++) {
			pair p = arr[i];
			if(check[p.y] == 0 && pc == p.x) {
				check[p.y] = 1;
				dfs(p.y);
			}else if(check[p.x] == 0 && pc == p.y) {
				check[p.x] = 1;
				dfs(p.x);
			}
		}
	}
}
