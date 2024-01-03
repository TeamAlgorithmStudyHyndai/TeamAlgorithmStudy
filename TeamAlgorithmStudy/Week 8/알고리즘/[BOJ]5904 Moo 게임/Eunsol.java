import java.util.Scanner;

public class Eunsol {

	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        int num = sc.nextInt();

	        System.out.println(moo(num));
	    }

	  private static char moo(int num) {
	        int len = 3;
	        int idx = 0;
	        while (num > len) {
	            idx++;
	            len = len * 2 + idx + 3; 
	        }

	        while (true) {
	            int mid = (len - idx - 3) / 2;
	            if (num <= mid) {
	                len = mid;
	            } else if (num > mid + idx + 3) {
	                num -= mid + idx + 3;
	                len = mid;
	            } else {
	                if (num == mid + 1) return 'm';
	                num -= mid + 1;
	                return 'o';
	            }
	            idx--;
	        }
	}
	//처음에 시도한 방법 => 메모리 초과
	private static Character makeConquer(int num) {
		String str = "";
		String beforeStr="";
		int index = 1;
		
		while(num >= str.length()) {
			
			beforeStr = (index == 1)? "moo" : str;
			
			StringBuffer bfr = new StringBuffer(beforeStr);
			
			StringBuffer paramBfr = new StringBuffer("m");
			for(int i = 0 ; i < index+2 ;i ++) {
				paramBfr.append("o");
			}
			str = bfr.append(paramBfr).append(beforeStr).toString();
			index++;
		}
		return str.charAt(num-1);
	}

}