import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main ma = new Main();
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int data = ma.greedy(num);
		System.out.println(data);
	}

	public int greedy(int num) {
		
	   int orginalNum = num;
	   
	    int maxIndex = num/5 ;
	    
      //5로 나눠질 경우 최대 maxIndex를 return
	    if(num %5 == 0)
	    	return maxIndex;
    
	    //5X +3Y가 만족하는 경우 해당 값 return
	    for(int i = maxIndex; i >0 ; i--) {
	    	num = orginalNum;
	    	
	    	num = num - i*5;
	    	
	    	if(num %3 == 0)
	    		return i + (num/3);
	    }
	    
           //3Y가 만족하는 경우 return
	    if(orginalNum %3 == 0)
	    	return orginalNum/3;
	  
        //5X , 3Y, 5x+3y을 모두 만족하지 못하는 경우 -1 return		
	      return -1;
	}

}