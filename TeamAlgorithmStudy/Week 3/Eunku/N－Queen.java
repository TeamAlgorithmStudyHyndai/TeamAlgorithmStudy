import java.util.Scanner;

public class Main {
    static int[] queen;
    static int N;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        queen = new int[N]; // {2,0,3,1}
        count = 0;
        solution(0);
        System.out.println(count);
    }
    static void solution(int depth){
        if(depth == N){
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            queen[depth] = i;
            if(check(depth)){
                solution(depth +1);
            }
        }
    }
    static boolean check(int col){
        for (int i = 0; i < col; i++) {
            if(queen[col] == queen[i]){
                return false;
            } else if(Math.abs(col-i)==Math.abs(queen[col]-queen[i])){
                return false;
            }
        }
        return true;
        }
}
