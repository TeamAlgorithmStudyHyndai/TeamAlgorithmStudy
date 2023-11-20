import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

public class Main {
	static int n, m;
	static Vector<road> v;
	static int[] check;
    static int res; 
    static class road{
    	int start;
    	int end;
    	int val;
    	public road(int start, int end, int val) {
    		this.start = start;
    		this.end = end;
    		this.val = val;
    	}
    }
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] nm = br.readLine().split(" ");
    	n = Integer.parseInt(nm[0]);
    	m = Integer.parseInt(nm[1]);
    	res = m + 1;
    	v = new Vector<>();
    	
    	for(int i =0; i<n; i++) {
    		String[] temp = br.readLine().split(" ");
    		int start = Integer.parseInt(temp[0]);
    		int end = Integer.parseInt(temp[1]);
    		int val = Integer.parseInt(temp[2]);
    		road r = new road(start,end,val);
    		if(end <= m && end - start > val)v.add(r);
    	}
    	Collections.sort(v, (o1,o2) -> o1.start != o2.start ? 
    					o1.start - o2.start  : o1.end - o2.end );
    	check = new int[v.size()];
    	for(int i = 0; i < v.size(); i++) {
        	road r = v.get(i);
        	dfs(r.start, r.end, r.val + r.start, i);	
    	}
    	if(res == m + 1) res = m;
    	System.out.println(res);
	}
	public static void dfs(int start, int end, int val, int idx) {
		if(idx == v.size() - 1) {
			val += (m - end);
			res = Math.min(val, res);
			return;
		}
		for(int i = idx + 1; i < v.size(); i++) {
			road r = v.get(i);
			if(check[i] == 0) {
				check[i] = 1;
				if(end <= r.start)
					dfs(r.start, r.end, val + r.val + r.start - end, i);
				else
					dfs(start, end, val, i);
				check[i] = 0;
			}
		}
	}
}