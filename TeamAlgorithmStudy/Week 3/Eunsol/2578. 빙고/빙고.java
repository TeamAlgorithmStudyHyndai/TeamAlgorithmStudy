import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int [][] arr;
	static int [][] call;
	static boolean check1 = false;
	static boolean check2 = false;
	static int totalCkCnt = 0;
	static Map<Integer, String> map = new HashMap<Integer, String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[5][5];
		call = new int[5][5];
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				arr[i][j] = sc.nextInt();
				map.put(arr[i][j], i+","+j);
			}
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				call[i][j] = sc.nextInt();
			}
		}
		int data = checkCall();
		System.out.println(data);
	}
	private static int checkCall() {
		int count = 0;
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(map.containsKey(call[i][j])) {
					String value = map.get(call[i][j]);
					int iKey = Integer.parseInt(value.split(",")[0]);
					int jKey = Integer.parseInt(value.split(",")[1]);
					
					arr[iKey][jKey] = 0;
					
					count++;//contains key가 O든 X든 count가 증가해야함
					
					checkMain(iKey, jKey);
					
					//세줄빙고가 완료된 경우
					if(totalCkCnt >=3) {
						 return count;
					} 
				}
			}
		}
		return 0;
	}
	
	private static void checkMain(int iKey, int jKey) {
	    int MainCkCnt1 = 0;
	    int MainCkCnt2 = 0;
	    int MainCkCnt3 = 0;
	    int MainCkCnt4 = 0;

	    for (int i = 0; i < 5; i++) {
	        if (arr[i][i] == 0)
	            MainCkCnt1++;  // i = j 왼쪽 대각선
	        if (arr[i][4 - i] == 0)
	            MainCkCnt2++; // 오른쪽 대각선
	        if (arr[iKey][i] == 0)
	            MainCkCnt3++; // 세로 빙고
	        if (arr[i][jKey] == 0)
	            MainCkCnt4++; // 가로 빙고
	    }

	    if (MainCkCnt1 == 5) {
	    	//왼쪽 대각선 처음 한번만 체크
	    	if(!check1) {
	    		check1 = true;
	    		totalCkCnt++;
	    	} 
	    }
	    if (MainCkCnt2 == 5) {
	    	//오른쪽 대각선 처음 한번만 체크
	    	if(!check2) {
	    		check2 = true;
	    		totalCkCnt++;
	    	} 
	    }
	    if (MainCkCnt3 == 5) {
	    	totalCkCnt++;
	    }
	    if (MainCkCnt4 == 5) {
	    	totalCkCnt++;
	    }
	}
}