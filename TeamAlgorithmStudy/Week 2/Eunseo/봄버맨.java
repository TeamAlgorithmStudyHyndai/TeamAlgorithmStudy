import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int r,c,n;
	static int[][] arr;
	static int[][] check;
	static int[] dx = {0,0,1,-1,0};
	static int[] dy = {-1,1,0,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        n = Integer.parseInt(s[2]);
        arr = new int[r][c];
        check = new int[r][c];
        for (int i = 0; i < r; i++) Arrays.fill(check[i], -1);
        for(int i = 0; i< r; i++) {
        	String s1 = br.readLine();
        	for(int j = 0; j< s1.length(); j++) {
        		if(s1.charAt(j) == '.') arr[i][j] = -1;
        		else {
        			arr[i][j] = 0;
        			check[i][j] = 0; //0초에 들어온 폭탄임을 표시
        		}
        	}
        }

        for(int i = 2; i<= n; i++) { 
        	if(i % 2 == 0) //짝수초: 폭탄 설치
        		setBomb(i);
        	else // 홀수초 : 폭탄 터짐
        		BombExploded(i);
        }
           
        for(int i=0;i<r;i++) {
        	for(int j =0; j< c; j++) {
        		if(arr[i][j] == -1) System.out.print('.');
        		else System.out.print('O');
        	}
            System.out.println();
        }
    }
        
    public static void setBomb(int sec) {
    	for(int j = 0; j < r; j++) {
    		for(int k = 0; k < c; k++) {
    			if(arr[j][k] == -1) {
    				arr[j][k] = 0;
    				check[j][k] = sec; //i초에 설치된 폭탄임을 표시
    			}
    		}
    	}
    }
    
    public static void BombExploded(int sec) {
    	for(int j = 0; j < r; j++) {
    		for(int k = 0; k < c; k++) {
    			if(check[j][k] + 3 == sec) { //3초전에 설치된 폭탄인가?
    				for(int h = 0; h < 5; h++) {
    					int xx = j + dx[h];
    					int yy = k + dy[h];
    					if(xx >= 0 && yy >= 0 && xx < r && yy < c)
    						arr[xx][yy] = -1;
    				}
    			}
    		}
    	}
    }
}
