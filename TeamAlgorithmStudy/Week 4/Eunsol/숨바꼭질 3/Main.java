package Week5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 수빈이 위치
        int N = sc.nextInt();

        // 동생의 위치
        int K = sc.nextInt();

        int[] arr = new int[100001];
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(N);
        arr[N] = 0;

        while (!queue.isEmpty()) {
            int q = queue.poll();

            // 반환된 위치가 같다면
            if (q == K) {
                System.out.println(arr[q]);
                break;
            }

            // 다음 포지션 가능위치, 2*Q, Q-1, q+1, 
            int[] nextPositions = { 2 * q ,q - 1, q + 1};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && arr[next] == 0) {
                    queue.add(next);
                    arr[next] = (next == 2 * q) ? arr[q] : arr[q] + 1;
                }
            }
        }

    }
}
