import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int K = sc.nextInt();

        // 입력값 배열 초기화
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int maxSum = 0;
        int currentSum = 0;

        // 초기 K일 동안의 합 구하기
        for (int i = 0; i < K; i++) {
            maxSum += arr[i];
        }

        currentSum = maxSum; // 초기값 설정

        // 투 포인터를 사용하여 연속된 K일 동안의 합 구하기
        int left = 0;
        for (int right = K; right < N; right++) {
            currentSum = currentSum - arr[left] + arr[right]; // 왼쪽 값을 뺀 후 오른쪽 값을 더함
            maxSum = Math.max(maxSum, currentSum); // 최대값 갱신
            left++; // 투 포인터 이동
        }

        System.out.println(maxSum);
    }
}
