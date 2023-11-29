import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public int solution(int[][] jobs) {
        int answer = 0;

        // 우선순위 큐 - 낮은 수부터
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        
        //아래 주석 해제 후 사용시, 정렬 기준이 모호해서 컴파일 오류 발생
        //PriorityQueue<int []> pq = new PriorityQueue<>();

        int index = 0;
        int totalJobs = jobs.length;
        int currentTime = 0;

        // 작업 시작 시간에 따라 정렬
        Arrays.sort(jobs, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        //n개의 jobs들을 다 끝내지 않았거나, 해당 우선순위 pq의 작업이 끝나지 않았다면
        while (index < totalJobs || !pq.isEmpty()) {
            while (index < totalJobs && jobs[index][0] <= currentTime) {
                pq.add(jobs[index]);
                index++;
            }
            
            //현재 실행 가능한 작업이 우선순위 큐에 존재하는지 check
            if (!pq.isEmpty()) {
                //가장 우선순위가 높은 큐를 poll();
                int[] currentJob = pq.poll();
                //현재 시간에 실행되는 작업 시간 add
                currentTime += currentJob[1];
                //대기시간 add
                answer += currentTime - currentJob[0];
            } else {
                // 실행가능한 작업이 큐에 없다면 => 가장 먼저도착한 작업을 기준으로
                currentTime = jobs[index][0];
            }
        }

        return answer / totalJobs;
    }
}
