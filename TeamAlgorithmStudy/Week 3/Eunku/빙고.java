import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] bingo = new int[5][5];
        boolean[][] check = new boolean[5][5];
        int cnt =0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = sc.nextInt();
            }
        }
        while(true){
            int temp = sc.nextInt();
            cnt++;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(bingo[i][j] == temp){
                        check[i][j] = true;
                    }
                }
            }
            if(cnt > 10){
                if(bingocheck(check)>=3){
                    System.out.println(cnt);
                    break;
                }
            }
        }
    }
    static int bingocheck(boolean[][] arr){
        int ans =0;
        for (int i = 0; i < 5; i++) {  //가로
            for (int j = 0; j < 5; j++) {
                if(!arr[i][j]) break;
                if(j ==4) ans++;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!arr[j][i]) break;
                if(j ==4) ans++;
            }
        }
        for (int i = 0; i < 5; i++) {
            if(!arr[i][i]) break;
            if(i ==4) ans++;
        }
        for (int i = 0; i < 5; i++) {
            if(!arr[i][4-i]) break;
            if(i ==4) ans++;
        }

        return ans;
    }
}
