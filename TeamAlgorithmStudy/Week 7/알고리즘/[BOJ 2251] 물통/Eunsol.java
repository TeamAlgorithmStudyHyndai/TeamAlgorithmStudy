import java.util.*;

public class Main {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        BFS(A, B, C);

        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void BFS(int A, int B, int C) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 0, C}); // 초기 상태 (첫 번째, 두 번째 물통은 비어있고, 세 번째 물통은 가득 참)

        while (!queue.isEmpty()) {
            int[] currentState = queue.poll();
            int x = currentState[0];
            int y = currentState[1];
            int z = currentState[2];

            if (visited.contains(x + " " + y + " " + z)) {
                continue; // 이미 방문한 상태인 경우 스킵
            }

            visited.add(x + " " + y + " " + z);
            if (x == 0) {
                set.add(z); // 첫 번째 물통이 비어있을 때 세 번째 물통의 물의 양 저장
            }

            // 물을 쏟는 모든 경우의 수를 탐색하여 큐에 추가
            int[][] nextStates = {
                    {Math.max(0, x - (B - y)), Math.min(B, y + x), z},
                    {Math.min(A, x + y), Math.max(0, y - (A - x)), z},
                    {Math.max(0, x - (C - z)), y, Math.min(C, z + x)},
                    {x, Math.max(0, y - (C - z)), Math.min(C, z + y)},
                    {Math.min(A, x + z), y, Math.max(0, z - (A - x))},
                    {x, Math.min(B, y + z), Math.max(0, z - (B - y))}
            };

            for (int[] nextState : nextStates) {
                queue.offer(nextState);
            }
        }
    }
}
