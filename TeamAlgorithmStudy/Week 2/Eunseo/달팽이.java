import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n,m;
	static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s2 = br.readLine();
        n = Integer.parseInt(s);
        m = Integer.parseInt(s2);
        arr = new int[n][n];
        int k = n * n;
        int x =0, y = 0;
        for(int i = 0; i< (n / 2 + 1); i++) {
        	while(x < n - i)
            	arr[x++][y] = k--;
            x -= 1;
            k += 1;
            while(y < n - i)
            	arr[x][y++] = k--;
            y -= 1;
            k += 1;
            while(x >= i)
            	arr[x--][y] = k--;
            x += 1;
            k += 1;
            while(y >= i + 1)
            	arr[x][y--] = k--;
            y += 1;
            k += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j< n; j++) {
        		sb.append(arr[i][j] + " ");
        		if(arr[i][j] == m) {
        			x = i + 1;
        			y = j + 1;
        		}
        	}
    		if(i != n -1)sb.append("\n");
        }
        System.out.println(sb.toString());
        System.out.println(x + " " + y);
    }
}
