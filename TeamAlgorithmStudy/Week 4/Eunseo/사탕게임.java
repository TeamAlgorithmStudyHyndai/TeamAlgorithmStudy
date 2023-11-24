
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int n,res;
	static char[][] arr,tmp;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for(int i =0; i< n; i++) {
        	String s = br.readLine();
        	for(int j =0; j< s.length(); j++)
        		arr[i][j] = s.charAt(j);
        }

    	tmp = new char[n][n];
    	for(int j =0; j<n; j++) tmp[j] = Arrays.copyOf(arr[j], n);
        for(int i =0; i<n; i++) {
        	change(i);
			if (res == n) break;
        }
        System.out.println(res);
    }
	public static void checkMaxNum(int x, int y) {
		int vertical = 0, horizon = 0;
		for(int i =0; i< n; i++) {
			if (res == n) return;
			Integer[] tempV = new Integer[n];
			tempV[0] = 1;
			Integer[] tempH = new Integer[n];
			tempH[0] = 1;
			for(int j = 1; j< n; j++) {
				if(tmp[i][j] == tmp[i][j-1]) tempV[j] = tempV[j-1]+1;
				else tempV[j] = 1;
				if(tmp[j][i] == tmp[j-1][i]) tempH[j] = tempH[j-1]+1;
				else tempH[j] = 1;
				
			}
			Arrays.sort(tempV, Collections.reverseOrder());
			Arrays.sort(tempH, Collections.reverseOrder());
			vertical = Math.max(vertical, tempV[0]);
			horizon = Math.max(horizon, tempH[0]);
			res = Math.max(res, Math.max(vertical,horizon));
		}
	}
	public static void change(int idx) {
		for(int i =1; i< n; i++) {
			if (res == n) return;
			if(tmp[idx][i] != tmp[idx][i-1]) {
				char c = tmp[idx][i];
				char b = tmp[idx][i-1];
				tmp[idx][i] = b;
				tmp[idx][i-1] = c;
	        	checkMaxNum(i,idx);
				tmp[idx][i] = c;
				tmp[idx][i-1] = b;
			}
			if(tmp[i][idx] != tmp[i-1][idx]) {
				char c = tmp[i][idx];
				char d = tmp[i-1][idx];
				tmp[i][idx] =  d;
				tmp[i-1][idx] = c;
	        	checkMaxNum(i,idx);
				tmp[i][idx] =  c;
				tmp[i-1][idx] = d;
			}	
		}
	}
}
