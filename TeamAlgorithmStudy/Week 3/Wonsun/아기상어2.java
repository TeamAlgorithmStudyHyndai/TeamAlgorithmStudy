package week3;
import java.io.*;
import java.util.*;

public class 아기상어2 {
    static int N, M;
    static int[][] arr;
    // 이동방향 : 상(0) 하(1) 좌(2) 우(3) ↗(4) ↖(5) ↙(6) ↘(7)
    static int[] dx = {0, 0, -1, 1, 1, -1, -1, 1};
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

    static class Node {
        int x, y;
        int distance;

        public Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.distance = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /* 입력 */
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        // ===== 배열 초기화 시작 ====== //
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // ===== 배열 초기화 끝 ====== //

        int maxLen = 0;
        /* 탐색 */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) continue; // 상어가 들어있는 노드 -> 제외
                int safeLength = getSafeLength(i, j); // bfs
                if (safeLength > maxLen) maxLen = safeLength;
            }
        }
        /* 출력 */
        System.out.println(maxLen);
    }

    // 안전거리를 구하는 메소드(BFS)
    static int getSafeLength(int y, int x) {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x, 0));
        visited[y][x] = true;
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll(); // 현재 노드 poll
            for (int i = 0; i < dx.length; i++) {
                int nextY = currentNode.y + dy[i];
                int nextX = currentNode.x + dx[i];

                // 배열 범위 잘못 참조하는 -> 스킵
                if (rangeCheck(nextY, nextX) == false) continue;
                // 이미 방문한 노드 -> 스킵
                if (visited[nextY][nextX]) continue;
                // 다음 노드가 아기 상어가 들어있는 노드인 경우 -> 거리 리턴
                if (arr[nextY][nextX] == 1) return Math.max(maxDistance, currentNode.distance + 1);
                // 다음 경우 탐색
                visited[nextY][nextX] = true;
                queue.add(new Node(nextY, nextX, currentNode.distance + 1));
                
            }
        }
        return maxDistance;
    }

    static boolean rangeCheck(int y, int x) {
        return (y >= 0 && x >= 0 && y < N && x < M);
    }
}
