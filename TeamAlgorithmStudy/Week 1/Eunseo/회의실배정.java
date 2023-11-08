import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        Integer[][] arr = new Integer[n][2];
        for(int i =0; i<n; i++) {
        	String[] str = br.readLine().split(" ");
        	arr[i][0] = Integer.parseInt(str[0]);
        	arr[i][1] = Integer.parseInt(str[1]);
        }
        Arrays.sort(arr, (o1,o2) -> (o1[1] == o2[1] ? o1[0].compareTo(o2[0]) : o1[1].compareTo(o2[1]) ));
//그리디보다 정렬이 더 까다로웠음....
        int answer = 1;
        int time = arr[0][1]; // 가장 빨리 끝나는 회의 시간
        for(int i =1; i<n; i++) {
        	if(arr[i][0] >= time) {
        		answer++;
        		time = arr[i][1];
        	}
        }
        System.out.println(answer);
    }
}
