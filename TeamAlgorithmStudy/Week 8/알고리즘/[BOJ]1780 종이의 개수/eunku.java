import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        answer = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <N ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count(0, 0, N);

        for (int i = 0; i <3 ; i++) {
            System.out.println(answer[i]);
        }
    }
    public static void count(int row, int col, int size){
        if(check(row, col, size)){
            if(arr[row][col] == -1){
                answer[0]++;
            } else if (arr[row][col] == 0) {
                answer[1]++;
            } else {answer[2]++;}
            return;
        }
        int newSize = size / 3;

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                count(row+ newSize*i, col + newSize*j, newSize);
            }
        }
    }
    public static boolean check(int row, int col, int size){
        int number = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(arr[i][j] != number){
                    return false;
                }
            }
        }
        return true;
    }

}
