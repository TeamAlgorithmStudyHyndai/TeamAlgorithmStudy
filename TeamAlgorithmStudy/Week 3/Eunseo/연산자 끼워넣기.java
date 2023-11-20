import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int n;
	static long max_res =-1000000000, min_res =1000000000;
	static int[] symb1, symb2, arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        symb1 = new int[4]; // + - * /
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        for(int i =0; i< n; i++)
        	arr[i] = Integer.parseInt(s1[i]);
        for(int i =0; i< 4; i++)
        	symb1[i] = Integer.parseInt(s2[i]);
        symb2 = symb1;
        check(arr[0], 1, 1);
        System.out.println(max_res);
        System.out.println(min_res);
	}
	public static void check(long num, int cnt, int idx) {
		if(cnt == n) {
			max_res = Math.max(num, max_res);
			min_res = Math.min(num, min_res);
			return;
		}
		for(int i =0; i < 4; i++) {
			if(symb1[i] > 0) {
				symb1[i] -= 1;
				if(i == 0)
					check(num + arr[idx] , cnt+1, idx + 1);
				else if(i == 1)
					check(num - arr[idx] , cnt+1, idx + 1);
				else if(i == 2)
					check(num * arr[idx] , cnt+1, idx + 1);
				else if(i == 3)
					check(num / arr[idx] , cnt+1, idx + 1);
				symb1[i] += 1;
			}
		}
	}
}