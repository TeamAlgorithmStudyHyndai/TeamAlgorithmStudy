package Week9;

import java.util.Scanner;

public class 겹치는건싫어_20922 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

    
        int[] frequency = new int[ N]; 
        
        int maxLength = 0;
        int start = 0;
        int end = 0;
        
        while(end < N) {
        	if(frequency[arr[end]] < K) {
        		frequency[arr[end]]++;
        		end++;
        		maxLength = Math.max(maxLength, end-start);
        	}else if(frequency[arr[end]] == K) {
        		frequency[arr[start]]--;
        		start++;
        		break;
            }
        }

        System.out.println(maxLength);
    }
}
