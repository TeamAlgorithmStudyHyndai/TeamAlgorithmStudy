package Week10;
import java.util.Scanner;

public class zero만들기_7490 {

    public static void findEquations(int N) {
        findEquationsHelper("1", 1, 0, 1, N);
    }

    public static void findEquationsHelper(String expr, int idx, int currentSum, int currentNum, int N) {
        if (idx == N) {
            if (currentSum + currentNum == 0) {
                System.out.println(expr);
            }
            return;
        }

        // '+' 연산자 추가
        findEquationsHelper(expr + "+" + (idx + 1), idx + 1, currentSum + currentNum, idx + 1, N);

        // '-' 연산자 추가
        findEquationsHelper(expr + "-" + (idx + 1), idx + 1, currentSum + currentNum, -1 * (idx + 1), N);

        // 공백 추가
        findEquationsHelper(expr + " " + (idx + 1), idx + 1, currentSum, currentNum * 10 + (idx + 1), N);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();

            findEquations(N);
            System.out.println();
        }

        scanner.close();
    }
}
