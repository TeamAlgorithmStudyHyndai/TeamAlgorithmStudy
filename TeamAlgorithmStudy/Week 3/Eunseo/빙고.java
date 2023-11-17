import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr;
	static boolean f1,f2;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        for(int i =0; i<5; i++) {
        	String[] s = br.readLine().split(" ");
        	for(int j=0; j<5; j++)
        		arr[i][j] = Integer.parseInt(s[j]);
        }
        int res = 0;
        int numOfLine = 0;
        for(int i =0; i<5; i++) {
        	String[] s = br.readLine().split(" ");
        	for(int j=0; j<5; j++) {
        		int a = Integer.parseInt(s[j]);
        		res++;
        		numOfLine += checking(a);
        		if(numOfLine >= 3) {
        			System.out.println(res);
        			return;
        		}
        	}
        }
	}
	public static int checking(int check) {
		int x =0, y = 0;
		int flag = 0; //for문 탈출용
		for(int i =0; i<5; i++) {
        	for(int j=0; j<5; j++) {
        		if(check == arr[i][j]) {
        			x = i;
        			y = j;
        			arr[i][j] = -1;
        			flag = 1;
        			break;
        		}
        	}
        	if(flag == 1) break;
		}
		int res = 0;
		int temp = 0;
		int resForReturn = 0;
		for(int j = 0; j < 5; j++) { //대각선
			if(!f1 && arr[j][j] == -1) res++;
			if(!f2 && arr[j][4 - j] == -1) temp++;
		}
		if(res == 5) {
			f1 = true;
			resForReturn++;
		}
		if(temp == 5) {
			f2 = true;
			resForReturn++;
		}
		res = 0;
		for(int j = 0; j < 5; j++) { //가로탐색
			if(arr[j][y] != -1) break; 
			res++;
		}
		if(res == 5) resForReturn++;
		res = 0;
		for(int j = 0; j < 5; j++) { //세로탐색
			if(arr[x][j] != -1) break; 
			res++;
    	}
		if(res == 5) resForReturn++;
		
		return resForReturn;
	}
}