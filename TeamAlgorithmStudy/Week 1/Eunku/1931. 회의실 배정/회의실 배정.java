import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Meeting> arr = new ArrayList<>();
        for (int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Meeting(x,y));
        }
        System.out.println(T.solution(arr));
    }

    public int solution(ArrayList<Meeting> arr){

        Collections.sort(arr);

        int end_time = 0;
        int answer = 0;
        for(Meeting m : arr){
            if(m.start>= end_time) {
                answer++;
                end_time = m.end;
            }

        }
        return answer;
    }
}

class Meeting implements Comparable<Meeting>{
    public int start,end;
    Meeting(int start, int end){
        this.start = start;
        this.end =end;
    }
    @Override
    public int compareTo(Meeting ob){
        if (this.end == ob.end){
            return this.start - ob.start;
        }
        return this.end - ob.end;
    }
}
