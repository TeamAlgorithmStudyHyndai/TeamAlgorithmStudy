import java.util.Scanner;

public class Main {
    static boolean[] check;

    static int[] line;
    static int[] cor;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        line = new int[n];
        cor = new int[n];
        check = new boolean[n];
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            line[i] = sc.nextInt();
        }

        for (int i = 0; i <n; i++) {
            int temp = checking(line[i], n);
            cor[temp] = i+1;
        }
        for (int a: cor) {
            System.out.print(a + " ");
        }
    }
    static int checking(int size, int n){
        int cnt = -1; // 최소 체크가 한개 남아있을 것이기 때문
        for (int i =0; i<n; i++) {
            if(check[i] == false) cnt++;
            if(size ==cnt){
                check[i] = true;
                return i;
            }

        };
        return Integer.MAX_VALUE;
    }
}
