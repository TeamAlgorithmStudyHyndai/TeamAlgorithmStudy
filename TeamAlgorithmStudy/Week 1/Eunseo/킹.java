import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char kingX;
	static int kingY;
	static char stoneX;
	static int stoneY;
	static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        kingX = str[0].charAt(0);
        kingY = str[0].charAt(1) - '0';
        stoneX = str[1].charAt(0);
        stoneY = str[1].charAt(1) - '0';
        int t = Integer.parseInt(str[2]);
        for(int x = 0; x< t; x++) {
        	String s = br.readLine();
        	flag = false;
        	char tempX = kingX;
    		int tempY = kingY;
        	for(int i =0; i< s.length(); i++) {
        		if(s.charAt(i) == 'R') kingX++;
        		else if(s.charAt(i) == 'L') kingX--;
        		else if(s.charAt(i) == 'B') kingY--;
        		else if(s.charAt(i) == 'T') kingY++;     		
        	}
        	if(kingX == stoneX && kingY == stoneY) {
        		char tx = stoneX;
        		int ty = stoneY;
        		for(int i =0; i<s.length(); i++) {
            		if(s.charAt(i) == 'R') stoneX++;
            		else if(s.charAt(i) == 'L') stoneX--;
            		else if(s.charAt(i) == 'B') stoneY--;
            		else if(s.charAt(i) == 'T') stoneY++;     		
            	}
        		if(!isIn(stoneX, stoneY)) {
        			stoneX = tx;
        			stoneY = ty;
        			kingX = tempX;
        			kingY = tempY;
        		}
    		}
        	if(!isIn(kingX, kingY)) {
        		kingX = tempX;
    			kingY = tempY;
        	}
        }
        String resK = kingX + Integer.toString(kingY);
        System.out.println(resK + "\n" + stoneX + stoneY);
                
    }
    public static boolean isIn(char x, int y) {//체스판 안인지 확인
    	if(x > 'H' || x < 'A' || y > 8 || y <= 0) return false;
    	return true;
    }
}
