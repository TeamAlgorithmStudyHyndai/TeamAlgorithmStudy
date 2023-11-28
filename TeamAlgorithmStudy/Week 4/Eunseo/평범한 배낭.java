import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s= br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);   
        int k = Integer.parseInt(s[1]);   
        int[][] arr = new int[n+1][2];
        int[][] bag = new int[n + 1][k + 1]; //물품이 n개이고 무게가 k일 때의 가치
        for(int i =1; i<=n; i++) {
        	String[] s2 = br.readLine().split(" ");
        	arr[i][0] = Integer.parseInt(s2[0]);   
        	arr[i][1] = Integer.parseInt(s2[1]); 
        	if(arr[i][0] <= k) bag[1][arr[i][0]] = arr[i][1];
        }
        for(int i = 1; i<= n; i++){ //최대 n개
        	for(int j = 1; j <=k; j++) { //최대 k 무게
        		if(arr[i][0] <= j)
        			bag[i][j] = Math.max(bag[i-1][j], arr[i][1] + bag[i-1][j-arr[i][0]]);
        		else bag[i][j] = bag[i-1][j];
        	}
        }
        int res = -1;
        for(int i =0;i<=k;i++) {
        	res = Math.max(res, bag[n][i]);
        }
        System.out.println(res);
    }	
}
