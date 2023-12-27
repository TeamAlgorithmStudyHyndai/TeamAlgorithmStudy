import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 나무의 수
        int M = sc.nextInt(); // 가져가려는 나무의 길이
        int[] trees = new int[N]; // 각 나무의 높이를 저장할 배열

        // 나무의 높이 입력 받기
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
        }

        // 이진 탐색을 위해 나무의 높이를 오름차순으로 정렬
        Arrays.sort(trees);

        // 이진 탐색을 통해 절단기에 설정할 수 있는 최댓값 찾기
        int start = 0;
        int end = trees[N - 1]; // 최대 높이는 가장 큰 나무의 높이
        int result = 0;

        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2; // 중간값

            // 중간값으로 설정한 높이로 나무를 잘랐을 때 가져갈 수 있는 총 길이 계산
            for (int tree : trees) {
                if (tree > mid) {
                    total += tree - mid;
                }
            }

            // 가져갈 수 있는 나무의 총 길이가 목표치(M)보다 작으면 높이를 낮춰야 함
            if (total < M) {
                end = mid - 1;
            }
            // 가져갈 수 있는 나무의 총 길이가 목표치(M) 이상이면 높이를 높여야 함
            else {
                result = mid; // 현재 설정한 높이를 결과로 저장
                start = mid + 1;
            }
        }

        System.out.println(result); // 최종 결과 출력
    }
}
