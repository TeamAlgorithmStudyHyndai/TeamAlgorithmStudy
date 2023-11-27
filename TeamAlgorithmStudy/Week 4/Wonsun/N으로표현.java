import java.util.*;  
  
class Solution {
    static int answer;
    public int solution(int N, int number) {  
        answer = -1;
        search(N, number, 0 , 0);
        
        return answer;
    }
    
    static void search(int N, int number, int result, int count)
    {
        if (count > 8) // 연산 횟수 8 번 넘어가면 -1 리턴
            return ; 
        if (result == number) // 원하는 숫자가 만들어졌으면 재귀 탈출
        {
            if (count < answer || answer == -1) 
            {
                answer = count;
                return ;
            }
        }
        
        int nN = 0; // N, NN, NNN, NNNN,.... 표기할 변수
        for (int i = 1; i <= 8; i++)
        {
            nN =  nN * 10 + N;
            search(N, number, result + nN, count + i); // +
            search(N, number, result - nN, count + i); // -
            search(N, number, result * nN, count + i); // *
            search(N, number, result / nN, count + i); // /
        }
        
    }
}
