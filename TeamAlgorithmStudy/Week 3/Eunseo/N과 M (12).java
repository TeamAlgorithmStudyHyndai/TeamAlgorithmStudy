import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr, res;
	static int n,m;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        String[] s = br.readLine().split(" ");
        arr = new int[n];
        res = new int[m];
        for(int i =0; i< n; i++)
        	arr[i] = Integer.parseInt(s[i]);
        Arrays.sort(arr);
        backtracking(0, 0);
	}
	public static void backtracking(int idx, int len) {
		if(len == m) {
			for(int i =0; i< m; i++)
				System.out.print(res[i] + " ");
			System.out.println();
			return;
		}
		int prevNum = -1;
		for(int i = idx; i< n; i++) {
			if(prevNum != arr[i]) {
				prevNum = arr[i];
				res[len] = arr[i];
				backtracking(i, len+1);
			}
		}
	}
}