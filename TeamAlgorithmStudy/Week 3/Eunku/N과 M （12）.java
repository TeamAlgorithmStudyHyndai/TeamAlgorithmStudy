import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static StringBuilder sb;
    static int[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        sb = new StringBuilder();
        list = new int[m];
        sol(0,0);
        System.out.println(sb);
    }

    static void sol(int start, int depth){
        if(depth == m){
            for (int a: list) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        int temp = -1;
        for(int i=start; i<n; i++){
            if(arr[i] != temp) {
                list[depth] = arr[i];
                temp = arr[i];
                sol(i, depth+1);
            }
        }
    }
}
