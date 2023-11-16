import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main ma = new Main();
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int [] arr = new int[num];
		
		for(int i = 0 ; i < num ; i++) 
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
        
		System.out.println(ma.greedy(arr));

	}

	public double greedy(int [] arr) {
		double sum = arr[arr.length-1];
		
		for(int i = arr.length-2; i > -1  ; i--) 
			sum += (double)arr[i]/2;
		
		return sum;
		
	}
}
