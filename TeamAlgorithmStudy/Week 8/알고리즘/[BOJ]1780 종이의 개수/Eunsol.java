
import java.util.Scanner;

public class Main {
    static int gray = 0;    // Count of cells filled with -1
    static int white = 0;   // Count of cells filled with 0
    static int black = 0;   // Count of cells filled with 1
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        arr = new int[num][num];

        // Input the matrix
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        divideAndConquer(0, 0, num);

        System.out.println(gray);
        System.out.println(white);
        System.out.println(black);
    }

    public static void divideAndConquer(int x, int y, int size) {
        if (checkUniform(x, y, size)) {
            int cellValue = arr[x][y];
            if (cellValue == -1) {
                gray++;
            } else if (cellValue == 0) {
                white++;
            } else {
                black++;
            }
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divideAndConquer(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }

    public static boolean checkUniform(int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
