package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] gear;
	static int k;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[4][8];
        for(int j = 0; j< 4; j++) {
            String s= br.readLine();
            for(int i =0; i<8; i++) gear[j][i] =s.charAt(i) - '0';   
        }
        k = Integer.parseInt(br.readLine());
        while(k-- != 0) {
        	String[] s= br.readLine().split(" ");   
            int numOfGear = Integer.parseInt(s[0]) - 1;     
            int dir = Integer.parseInt(s[1]); 
            checkOtherGear(numOfGear, dir);
            spinGear(numOfGear, dir);

        }
        int res = 0;
        for(int i =0; i<4; i++) {
        	if(gear[i][0] == 1) {
        		res += Math.pow(2, i);
        	}
        }
        System.out.println(res);
    }
	public static void spinGear(int idx, int dir) {
		if(dir == 1) { //시계방향
			int tmp = gear[idx][7];
			for(int i = 6; i >= 0; i--) gear[idx][i+1] = gear[idx][i];
			gear[idx][0] = tmp;
		}
		else {	//반시계 방향
			int tmp = gear[idx][0];
			for(int i = 1; i <= 7; i++) gear[idx][i-1] = gear[idx][i];
			gear[idx][7] = tmp;
			
		}
	}
	public static void checkOtherGear(int idx, int dir) {
		if(idx == 0) { //0번 2톱니 - 1번 6톱니
			if(gear[0][2] != gear[1][6]) {
				if(gear[1][2] != gear[2][6]) {
					if(gear[2][2] != gear[3][6]) {
						spinGear(3,dir* -1);
					}
					spinGear(2,dir);
				}
				spinGear(1,dir*-1);
			}
		}
		else if(idx == 1) { //0번 2톱니 - 1번 6톱니
			if(gear[0][2] != gear[1][6]) spinGear(0,dir * -1);
			if(gear[1][2] != gear[2][6]) {
				if(gear[2][2] != gear[3][6]) {
					spinGear(3,dir);
				}
				spinGear(2,dir * -1);
			}
		}
		else if(idx == 2) { //0번 2톱니 - 1번 6톱니
			if(gear[1][2] != gear[2][6]) {
				if(gear[0][2] != gear[1][6]) {
					spinGear(0,dir);
				}
				spinGear(1,dir * -1);
			}
			if(gear[2][2] != gear[3][6]) spinGear(3,dir * -1);	
		}
		else if(idx == 3) { //0번 2톱니 - 1번 6톱니
			if(gear[2][2] != gear[3][6]) {
				if(gear[1][2] != gear[2][6]) {
					if(gear[0][2] != gear[1][6]) {
						spinGear(0,dir* -1);
						}
					spinGear(1,dir);
					}
				spinGear(2,dir*-1);
			}
		}
	}
}



