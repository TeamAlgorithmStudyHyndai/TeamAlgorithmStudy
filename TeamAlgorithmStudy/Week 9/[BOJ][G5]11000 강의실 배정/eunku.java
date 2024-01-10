import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);
        for (int i = 1; i < N; i++) {
            if(pq.peek() <= arr[i][0]) pq.poll();

            pq.add(arr[i][1]);
        }

        System.out.println(pq.size());

    }
}
