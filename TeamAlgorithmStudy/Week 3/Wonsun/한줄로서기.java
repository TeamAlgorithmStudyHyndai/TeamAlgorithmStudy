package week3;

import java.io.*;
import java.util.*;
public class 한줄로서기 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/******* 입력 시작 *******/
        int N = Integer.parseInt(br.readLine());
        int []inputArr = new int[N];
        List<Integer> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) 
        {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        /******* 입력 끝 *******/
        // 키가 큰 순서대로
        for(int i = N - 1; i >= 0; i--)
        {
          // 키가 h 인 사람 보다 왼쪽에 더 큰사람 n 명 있다
          // => list의 n 번 인덱스에 h 를 추가
        	list.add(inputArr[i], i + 1);
        }
        /******** 출력 *********/
        for(int h : list)
        {
        	System.out.print(h + " ");
        }
    }
	
	
}
