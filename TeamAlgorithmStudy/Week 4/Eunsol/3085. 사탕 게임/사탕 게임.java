import java.util.Scanner;

public class Main {

    static char[][] arr;  // 사탕의 색을 char로 저장

    static int maxCount = 0;  // 먹을 수 있는 최대 사탕 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        arr = new char[num][num];

        for (int i = 0; i < num; i++) {
            String str = sc.next();
            for (int j = 0; j < num; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        findMaxCandies();
        System.out.println(maxCount);
    }

    public static void findMaxCandies() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (j + 1 < arr[0].length) {
                    swapAndCheck(i, j, i, j + 1);
                }
                if (i + 1 < arr.length) {
                    swapAndCheck(i, j, i + 1, j);
                }
            }
        }
    }

    public static void swapAndCheck(int x1, int y1, int x2, int y2) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;

        // 교환 후에 가장 긴 연속 부분을 찾아 maxCount 업데이트
        checkRow();
        checkCol();

        // 복귀
        tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }

    public static void checkRow() {
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
    }

    public static void checkCol() {
        for (int i = 0; i < arr[0].length; i++) {
            int count = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j][i] == arr[j - 1][i]) {
                    count++;
                } else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
    }
}
