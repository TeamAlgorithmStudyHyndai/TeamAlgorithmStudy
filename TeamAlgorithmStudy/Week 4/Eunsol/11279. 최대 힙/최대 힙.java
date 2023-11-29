

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    
     // 낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
    // PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
    
    // 높은 숫자가 우선 순위인 int형 우선순위 큐 선언
	static PriorityQueue<Integer> pgH = new PriorityQueue<>(Collections.reverseOrder());
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        int[] arr = new int[num];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i < arr.length; i++) {
           if(arr[i] == 0  ) {
        	   //1-1. 배열 숫자가 0이고, pqH가 빈 경우
        	   if(pgH.size() == 0)
        		   System.out.println("0"); 
        	   //1-2. 배열 숫자가 0이고, pqH에 값이존재하는 경우 : Max값 반환
        	   else {
        		   System.out.println(pgH.poll()); 
        	   }
           }else {
        	   //2-1.배열 숫자가 일반 자연수인 경우 값 add(0 제외)
        	   pgH.add(arr[i]);
           }
        	   
        }
    }
}
