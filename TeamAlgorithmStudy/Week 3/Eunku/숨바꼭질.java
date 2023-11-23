import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] map;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수빈이 위치
        int m = sc.nextInt(); // 동생 위치
        map = new int[100001];
        visit = new boolean[100001];
        Queue<Integer> que = new LinkedList<>();
        que.offer(n);
        int x_move = 0;
        visit[n] = true;
        if(n == m){
            System.out.println(0);
            return;
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    x_move = x + 1;
                } else if (i == 1) {
                    x_move = x - 1;
                } else if (i == 2) {
                    x_move = 2 * x;
                }
                if (x_move >= 100001 || x_move < 0) continue;

                if (!visit[x_move]) {
                    map[x_move] = map[x] + 1;
                    visit[x_move] = true;
                    que.offer(x_move);
                }
            }
            if (map[m] != 0) {
                System.out.println(map[m]);
                break;
            }
        }
    }
}
