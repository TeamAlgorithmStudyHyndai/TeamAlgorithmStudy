import java.util.*;

class Solution {
    static String[] arr;
    static int[] visit;
    static int[][] conn;

    public int solution(String begin, String target, String[] words) {
        arr = new String[words.length + 1];
        int n = arr.length;
        arr[0] = begin;
        for (int i = 1; i < n; i++) {
            arr[i] = words[i - 1];
        }
        int m = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(target)) {
                m = i;
                break;
            }
        }
        visit = new int[n];
        conn = new int[n][n];
        for (int i = 0; i < n; i++) {
            String a = arr[i];
            for (int j = 0; j < n; j++) {
                String b = arr[j];
                int cnt = 0;
                for (int k = 0; k < target.length(); k++) {
                    if (a.charAt(k) == b.charAt(k)) {
                        cnt++;
                    }
                }
                if (cnt == target.length() - 1) {
                    conn[i][j] = 1;
                    conn[j][i] = 1;
                }
            }
        }

        return bfs(m);
    }

    static int bfs(int m) {
        if (m == -1) return 0;

        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        visit[0] = 1;
        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int i = 0; i < conn[temp].length; i++) {
                if (conn[temp][i] == 1 && visit[i] ==0) {
                    visit[i] = visit[temp] + 1;
                    que.offer(i);
                }
            }
        }
        return visit[m]-1;
    }
}