import java.util.*;
class Solution {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        int num = 0;
        int res = jobs[0][1];
        int time = jobs[0][0] + jobs[0][1];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0); //해결한 작업들 인덱스번호
        while(num != jobs.length){
            int idx = -1;
            int min = Integer.MAX_VALUE;
            for(int i =0; i< jobs.length; i++){
                if(jobs[i][0] <= time && jobs[i][1] < min && !list.contains(i)){
                    idx = i;
                    min = jobs[i][1];
                }
            }
            if(idx == -1){
                for(int i =0; i< jobs.length; i++){
                    if(!list.contains(i)) {
                        idx = i;
                        res += jobs[idx][1];
                        time = jobs[idx][0] + jobs[idx][1];
                        break;
                    }
                }
            }
            else{
                res += time - jobs[idx][0] + jobs[idx][1];
                time += jobs[idx][1];
            }              
            list.add(idx);
            num++;
        }
        int answer = (int)(Math.floor((double)res / (double) jobs.length));
        return answer;
    }
}
