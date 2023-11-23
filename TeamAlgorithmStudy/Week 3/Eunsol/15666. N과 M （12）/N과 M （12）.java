import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Main {

    private static int[] arr;
    private static Set<Integer> set = new HashSet<>();
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        //중복을 제거하기 위해 set에 넣음
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        Integer[] sortedArr = set.toArray(new Integer[0]);
        Arrays.sort(sortedArr);

        arr = Arrays.stream(sortedArr).mapToInt(Integer::intValue).toArray();

        Main ma = new Main();

        ma.backTracking(0, 0, "");
    }

    public void backTracking(int startIndex, int depth, String str) {
        if (depth == m) {
            System.out.println(str);
            return;
        } else {
        	//중복을 제거했기 때문에 i의 최대 n이 아니라 arr.length를 기준으로 잡아야함
            for (int i = startIndex; i < arr.length; i++) {
                backTracking(i, depth + 1, str + arr[i] + " ");
            }
        }
    }
}