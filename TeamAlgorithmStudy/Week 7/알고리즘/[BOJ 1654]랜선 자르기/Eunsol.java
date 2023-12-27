import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int []arr ;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long num = sc.nextInt();
		long minCnt = sc.nextInt();
		
		arr = new int[(int) num];
		for(int i = 0 ; i <num ; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		long cutSum = 0;
		
		long start = 1;
		long end = arr[(int) (num - 1)]; 
		long mid = 0;
		long result = 0;
	    
		while(start <= end) {
			cutSum = 0;
			mid = ( start + end ) /2;
			
			if(mid != 0) {
				for(int i = 0 ; i <num ; i++) {
					cutSum += arr[i]/ mid;
				}
			}

            if (cutSum >= minCnt) {
                result = mid;
                start = mid + 1; 
            } else {
                end = mid - 1; 
            }
				
		}
		System.out.println(result);
		
	}
}