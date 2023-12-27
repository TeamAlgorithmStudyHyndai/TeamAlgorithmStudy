

import java.util.Scanner;

public class Main {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N];
        int totalLength = 0;
        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            totalLength += arr[i];
            maxLength = Math.max(maxLength, arr[i]);
        }

        int start = maxLength;
        int end = totalLength;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isPossible(mid, M)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }

    static boolean isPossible(int maxLength, int allowedBluRays) {
        int bluRayCount = 1;
        int currentLength = 0;

        for (int lesson : arr) {
            if (currentLength + lesson > maxLength) {
                bluRayCount++;
                currentLength = lesson;
            } else {
                currentLength += lesson;
            }
        }

        return (bluRayCount <= allowedBluRays)? true: false;
    }
}
