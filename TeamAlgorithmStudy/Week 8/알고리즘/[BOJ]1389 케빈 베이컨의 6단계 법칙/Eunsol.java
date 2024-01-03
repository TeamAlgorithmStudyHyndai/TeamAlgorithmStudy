import java.util.Scanner;

public class Eunsol {
    static int[][] arr;
    private static final int INF = Integer.MAX_VALUE / 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 노드 수 입력
        int M = sc.nextInt(); // 간선 수 입력
        arr = new int[N + 1][N + 1];

        // 인접행렬 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    arr[i][j] = 0; // 자기 자신까지의 거리는 0
                } else {
                    arr[i][j] = INF; // 나머지는 무한대로 초기화
                }
            }
        }

        // 그래프의 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            arr[num1][num2] = 1;
            arr[num2][num1] = 1;
        }

        // 플로이드-와샬 알고리즘을 사용하여 최단 경로 계산
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int ans = -1;
        int min = INF;

        // 각 노드에서 다른 모든 노드까지의 거리 합을 계산하여 가장 작은 값을 가지는 노드 찾기
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += arr[i][j];
            }

            if (min > sum) {
                min = sum;
                ans = i;
            }
        }

        System.out.println(ans); // 거리 합이 가장 작은 노드 출력
    }
}
