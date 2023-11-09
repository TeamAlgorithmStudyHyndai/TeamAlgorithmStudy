import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String[] moving = {"R", "L","B","T","RT", "LT","RB", "LB"};
    static int[] xMove = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] yMove = {0, 0, -1, 1, 1, 1, -1, -1};
    static String[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String kingTemp = st.nextToken();

        int[] startKing = {kingTemp.charAt(0)-64 , kingTemp.charAt(1) - 48};

        String stoneTemp = st.nextToken();
        int[] startStone = {stoneTemp.charAt(0)-64 , stoneTemp.charAt(1)-48};
        int n = Integer.parseInt(st.nextToken());
        arr = new String[n];
        for (int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        List<String> list = Arrays.asList(moving);
        for (String str : arr){
            int x = list.indexOf(str);
            if(startKing[0] +xMove[x] <=0 || startKing[0] +xMove[x] > 8 ||
                startKing[1] +yMove[x] <=0 || startKing[1] +yMove[x] > 8){
                continue;
            }
            startKing[0] += xMove[x];
            startKing[1] += yMove[x];
            if(Arrays.equals(startKing, startStone)){
                if(startStone[0] +xMove[x] <=0 || startStone[0] +xMove[x] > 8 ||
                        startStone[1] +yMove[x] <=0 || startStone[1] +yMove[x] > 8){
                    startKing[0] -= xMove[x];
                    startKing[1] -= yMove[x];
                } else {
                    startStone[0] += xMove[x];
                    startStone[1] += yMove[x];
                }
            }
        }

        System.out.println((char)(startKing[0]+64) +""+ startKing[1]);
        System.out.println((char)(startStone[0]+64)+""+ startStone[1]);

    }
}