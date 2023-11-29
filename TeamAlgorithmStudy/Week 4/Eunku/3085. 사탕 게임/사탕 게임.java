import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                char temp = arr[i][j];
                char temp_1 = arr[i][j+1];

                arr[i][j] = temp_1;
                arr[i][j+1] = temp;    //두 위치 교환

                ans[i][j] = Math.max(Math.max(checkCol(arr, i, j, temp_1), checkRow(arr, i , j,  temp_1)), ans[i][j]);
                ans[i][j+1] = Math.max(Math.max(checkCol(arr, i, j+1, temp), checkRow(arr, i , j+1,  temp)), ans[i][j+1]);

                arr[i][j] = temp;
                arr[i][j+1] = temp_1;    //원상 복귀

                // 다음 세로 변환

                temp = arr[j][i];
                temp_1 = arr[j+1][i];

                arr[j][i] = temp_1;
                arr[j+1][i] = temp;    //두 위치 교환

                ans[j][i] = Math.max(Math.max(checkCol(arr, j, i, temp_1), checkRow(arr, j , i,  temp_1)), ans[j][i]);
                ans[j+1][i] = Math.max(Math.max(checkCol(arr, j+1, i, temp), checkRow(arr, j+1 , i,  temp)), ans[j+1][i]);

                arr[j][i] = temp;
                arr[j+1][i] = temp_1;    //원상 복귀
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(ans[i][j], max);
            }
        }
        System.out.println(max);
    }
    public static int checkCol(char[][] arr,int row, int col,  char a){
        int count = 1;
        for (int i = row+1; i < arr.length; i++) {
            if(arr[i][col] == a){
                count++;
            } else break;
        }
        for (int i = row-1; i >= 0; i--) {
            if(arr[i][col] == a){
                count++;
            } else break;
        }
        return count;
    }
    public static int checkRow(char[][] arr, int row, int col,  char a){
        int count = 1;
        for (int i = col+1; i < arr.length; i++) {
            if(arr[row][i] == a){
                count++;
            } else break;
        }
        for (int i = col-1; i >=0; i--) {
            if(arr[row][i] == a){
                count++;
            } else break;
        }
        return count;
    }
}
