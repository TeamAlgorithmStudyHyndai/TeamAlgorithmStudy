import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<int[]> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int answer = 0;
    
        int j =0;
        int start_time=0;
        int[] temp;
        for (int i=0; i<jobs.length; i++){
            for( ;j<jobs.length; j++){
                if(jobs[j][0]<=start_time){
                    pQ.offer(jobs[j]);
                }else break;
            }
            if(!pQ.isEmpty()){
                temp = pQ.poll();
                start_time += temp[1];
                answer += (start_time- temp[0]);
            }else {
                start_time = jobs[i][0];
                i--;}
        
    }
        return answer/ jobs.length;
    }
}