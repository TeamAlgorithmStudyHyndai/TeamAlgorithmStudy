package week3;

import java.util.*;
public class Nqueen {
	public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    static void nQueen(int depth) 
    {
        // 모든 원소를 다 채운 상태면 count 증가 및 return
        if (depth == N) 
        {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) 
        {
            arr[depth] = i;
            if (checkCondition(depth) == true) 
                nQueen(depth + 1);
        }
    }
    
    static boolean checkCondition(int depth) {
        for (int i = 0; i < depth; i++) 
        {
            if (arr[depth] == arr[i]) 
                return false; // 같은 열
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) 
                return false; // 대각선
        }
        return true;
    }
}
